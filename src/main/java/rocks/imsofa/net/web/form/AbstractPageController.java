/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.net.web.form;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * a PageController controls a page it must contain a RestController annotation,
 * a View annotation and several ViewEvent annotations
 *
 * @author s1088
 */
public abstract class AbstractPageController<T> {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping = null;
    private String path = null;
    private String pageTemplate;
    private String layout = null;
    private Class pageClass = null;
    private Scope scope = null;

    @PostConstruct
    protected void init() {
        try {
            View pageAnnotation = this.getClass().getAnnotation(View.class);
            pageTemplate = pageAnnotation.view();
            if (pageTemplate.contains("::") == false) {
                pageTemplate = pageTemplate + " :: Main";
            }
            layout = pageAnnotation.layout();
            path = pageAnnotation.paths()[0];
            pageClass = pageAnnotation.pageClass();
            scope = pageAnnotation.scope();

            RequestMappingInfo mappingInfo = RequestMappingInfo.paths(pageAnnotation.paths()).methods(RequestMethod.GET).build();
            Method method = this.getClass().getMethod("indexAction", HttpServletRequest.class);
            requestMappingHandlerMapping.registerMapping(mappingInfo, this, method);

            mappingInfo = RequestMappingInfo.paths(pageAnnotation.paths()).methods(RequestMethod.POST).build();
            method = this.getClass().getMethod("fireUpdateEvent", HttpServletRequest.class, HttpServletResponse.class, ViewEventArg.class);
            requestMappingHandlerMapping.registerMapping(mappingInfo, this, method);
//            System.out.println(Arrays.deepToString(this.getClass().getAnnotations()));
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ModelAndView indexAction(HttpServletRequest request) {
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Page<T> page = this.createPageInstance(request);
//        T viewModel=this.initViewModel(request, pathVariables);
        T viewModel = page.init(request, pathVariables);
        Map model = Map.of("viewModel", viewModel, "pageTemplate", pageTemplate, "path", path);
        return new ModelAndView(layout, model);
    }

    protected Page createPageInstance(HttpServletRequest request) {
        try {
            PageInstanceContainer scopeContainer = new PageInstanceContainer(request, scope);
            //leaving previous page (in the scope) if existed
            Page existingPage = scopeContainer.getPage(pageClass);
            if (existingPage != null) {
                System.out.println("reuse");
                return existingPage;
            } else {
                System.out.println("new");
                Page page = (Page) this.pageClass.getDeclaredConstructor().newInstance();
                scopeContainer.savePage(page);
                return page;
            }
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public T fireUpdateEvent(HttpServletRequest request, HttpServletResponse response, @RequestBody ViewEventArg<T> arg) {
        Page<T> page = this.createPageInstance(request);
        Method[] methods = page.getClass().getDeclaredMethods();
        for (Method method : methods) {
            ViewEvent handler = method.getAnnotation(ViewEvent.class);
            if (handler != null && handler.value().equals(arg.getName())) {
                try {
                    ViewContext<T> viewContext = new ViewContext<>();
                    viewContext.setRequest(request);
                    viewContext.setResponse(response);
                    viewContext.setViewModel(arg.getViewModel());
                    T viewModel = (T) method.invoke(page, viewContext);
                    return viewModel;
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(AbstractPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
