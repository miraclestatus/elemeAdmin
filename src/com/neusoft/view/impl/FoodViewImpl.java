package com.neusoft.view.impl;

import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/10 14:30
 */
public class FoodViewImpl implements FoodView {


    @Override
    public void showFoodList(Integer businessId) {

        FoodDaoImpl dao = new FoodDaoImpl();
        List<Food> foodList = dao.findAll(businessId);
        System.out.println("食品编号" + "\t" +"食品名称");
        for (Food food :foodList){
            System.out.println(food.getFoodId() + "\t" + food.getFoodName());
        }
    }

    @Override
    public void saveFood(Integer businessId) {

    }

    @Override
    public void updateFood(Integer businessId) {

    }

    @Override
    public void removeFood(Integer businessId) {

    }
}
