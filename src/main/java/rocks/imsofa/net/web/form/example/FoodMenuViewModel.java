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
public class FoodMenuViewModel {
    private List<String> categories=new ArrayList<>();
    private List<String> foods=new ArrayList<>();
    private List<String> ordered=new ArrayList<>();
    private String currentCategory;
    private String currentFood;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    public List<String> getOrdered() {
        return ordered;
    }

    public void setOrdered(List<String> ordered) {
        this.ordered = ordered;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }

    public String getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(String currentFood) {
        this.currentFood = currentFood;
    }
    
    
}
