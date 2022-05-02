/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.net.web.form;

/**
 *
 * @author s1088
 */
public class ViewEventArg<T> {
    private String name;
    private T viewModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }
    
}
