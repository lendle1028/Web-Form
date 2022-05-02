/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lendle
 */
public class ViewContext<T> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private T viewModel;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }
    
}
