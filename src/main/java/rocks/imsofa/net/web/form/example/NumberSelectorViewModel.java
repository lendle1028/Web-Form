/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lendle
 */
public class NumberSelectorViewModel {
    private Integer startValue=-1;
    private List<Integer> sequentialValues=new ArrayList<>();
    private Integer selectedSecondValue=-1;

    public Integer getStartValue() {
        return startValue;
    }

    public void setStartValue(Integer startValue) {
        this.startValue = startValue;
    }

    public List<Integer> getSequentialValues() {
        return sequentialValues;
    }

    public void setSequentialValues(List<Integer> sequentialValues) {
        this.sequentialValues = sequentialValues;
    }

    public Integer getSelectedSecondValue() {
        return selectedSecondValue;
    }

    public void setSelectedSecondValue(Integer selectedSecondValue) {
        this.selectedSecondValue = selectedSecondValue;
    }
    
    
}
