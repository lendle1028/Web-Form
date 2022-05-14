/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.ArrayList;
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
public class FoodMenuPage implements Page<FoodMenuViewModel>{
    private Map<String, String> foods=Map.of(
            "吉士堡", "漢堡",
            "香雞堡", "漢堡",
            "滿福堡", "漢堡",
            "可樂", "飲料",
            "果汁", "飲料",
            "紅茶", "飲料",
            "薯條", "點心",
            "雞塊", "點心",
            "冰淇淋", "點心"
    );
    @Override
    public FoodMenuViewModel init(HttpServletRequest request, Map pathVariables) {
        FoodMenuViewModel foodMenuViewModel=new FoodMenuViewModel();
        foodMenuViewModel.setCategories(List.of("漢堡", "飲料", "點心"));
        foodMenuViewModel.setCurrentCategory("漢堡");
        foodMenuViewModel.setFoods(getFoods("漢堡"));
        foodMenuViewModel.setCurrentFood(foodMenuViewModel.getFoods().get(0));
        return foodMenuViewModel;
    }
    
    private List<String> getFoods(String category){
        List<String> food=new ArrayList<>();
        for(String key : foods.keySet()){
            if(category.equals(foods.get(key))){
                food.add(key);
            }
        }
        return food;
    }
    
    @ViewEvent("selectCategory")
    public FoodMenuViewModel selectCategory(ViewContext<FoodMenuViewModel> viewContext){
        FoodMenuViewModel foodMenuViewModel=viewContext.getViewModel();
        foodMenuViewModel.setFoods(getFoods(foodMenuViewModel.getCurrentCategory()));
        foodMenuViewModel.setCurrentFood(foodMenuViewModel.getFoods().get(0));
        return foodMenuViewModel;
    }
    
    @ViewEvent("addFood")
    public FoodMenuViewModel addFood(ViewContext<FoodMenuViewModel> viewContext){
        FoodMenuViewModel foodMenuViewModel=viewContext.getViewModel();
        foodMenuViewModel.getOrdered().add(foodMenuViewModel.getCurrentFood());
        return foodMenuViewModel;
    }

}
