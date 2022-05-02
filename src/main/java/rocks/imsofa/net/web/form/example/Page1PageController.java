/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.net.web.form.example;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import rocks.imsofa.net.web.form.AbstractPageController;
import rocks.imsofa.net.web.form.View;
import rocks.imsofa.net.web.form.ViewContext;
import rocks.imsofa.net.web.form.ViewEvent;

/**
 *
 * @author s1088
 */
@RestController
@View(paths={"/page1", "/page1/name/{name}"}, view="/page1")
public class Page1PageController extends AbstractPageController<Test1Bean>{

    @Override
    protected Test1Bean initViewModel(HttpServletRequest request, Map pathVariables) {
        Test1Bean test1Bean=new Test1Bean();
        test1Bean.setAttr1(""+System.currentTimeMillis());
        return test1Bean;
    }
    
    @ViewEvent("attrUpdated")
    protected Test1Bean update(ViewContext<Test1Bean> viewContext){
        Test1Bean test1Bean=viewContext.getViewModel();
        test1Bean.setAttr2(test1Bean.getAttr2()+1);
        return test1Bean;
    }
    
    @ViewEvent("attr1Updated")
    protected Test1Bean update2(ViewContext<Test1Bean> viewContext){
        Test1Bean test1Bean=viewContext.getViewModel();
        test1Bean.setAttr2(Integer.valueOf(test1Bean.getAttr1()));
        return test1Bean;
    }
}
