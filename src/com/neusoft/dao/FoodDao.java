package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {

    // crud方法是必须的
    public List<Food> findAll(Integer businessId);
    public Food getFoodById(Integer foodId);
    public int saveFood(Food food);
    public int updateFood(Food food);
    public int removeFood(Integer foodId);



}
