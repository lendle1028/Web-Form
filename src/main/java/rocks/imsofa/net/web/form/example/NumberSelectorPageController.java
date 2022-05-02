/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import rocks.imsofa.net.web.form.AbstractPageController;
import rocks.imsofa.net.web.form.View;
import rocks.imsofa.net.web.form.ViewContext;
import rocks.imsofa.net.web.form.ViewEvent;

/**
 *
 * @author lendle
 */
@RestController
@View(paths={"/numberSelector"}, view="/numberSelector")
public class NumberSelectorPageController extends AbstractPageController<NumberSelectorViewModel>{

    @Override
    protected NumberSelectorViewModel initViewModel(HttpServletRequest request, Map pathVariables) {
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
