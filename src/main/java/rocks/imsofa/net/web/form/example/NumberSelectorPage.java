/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import rocks.imsofa.net.web.form.Page;
import rocks.imsofa.net.web.form.ViewContext;
import rocks.imsofa.net.web.form.ViewEvent;

/**
 *
 * @author lendle
 */
public class NumberSelectorPage implements Page<NumberSelectorViewModel>{

    @Override
    public NumberSelectorViewModel init(HttpServletRequest request, Map pathVariables) {
        NumberSelectorViewModel vm=new NumberSelectorViewModel();
        vm.setStartValue(1);
        vm.setSequentialValues(List.of(1, 2, 3, 4, 5));
        vm.setSelectedSecondValue(1);
        return vm;
    }
    
    @ViewEvent("startValueUpdated")
    public NumberSelectorViewModel update(ViewContext<NumberSelectorViewModel> viewContext){
        NumberSelectorViewModel model=viewContext.getViewModel();
        model.setSequentialValues(List.of(model.getStartValue(), model.getStartValue()+1, model.getStartValue()+2, model.getStartValue()+3, model.getStartValue()+4));
        model.setSelectedSecondValue(model.getStartValue());
        return model;
    }
    
}
