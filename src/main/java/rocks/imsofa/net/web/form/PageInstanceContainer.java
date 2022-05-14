/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lendle
 */
public class PageInstanceContainer {

    private HttpServletRequest request = null;
    private Scope scope = null;

    public PageInstanceContainer(HttpServletRequest request, Scope scope) {
        this.request = request;
        this.scope = scope;
    }

    public Page getPage(Class pageClass) {
        switch (scope) {
            case REQUEST:
                return (Page) request.getAttribute(pageClass.getName());
            case SESSION:
                return (Page) request.getSession().getAttribute(pageClass.getName());
            case APPLICATION:
                return (Page) request.getServletContext().getAttribute(pageClass.getName());
        }
        return null;
    }
    
    public void savePage(Page object){
        switch (scope) {
            case REQUEST:
                request.setAttribute(object.getClass().getName(), object);
                break;
            case SESSION:
                request.getSession().setAttribute(object.getClass().getName(), object);
                break;
            case APPLICATION:
                request.getServletContext().setAttribute(object.getClass().getName(), object);
        }
    }
}
