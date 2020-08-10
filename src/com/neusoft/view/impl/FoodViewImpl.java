package com.neusoft.view.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/10 14:30
 */
public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);


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
        Food food = new Food();
        System.out.println("请输入食品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入食品介绍：");
        food.setFoodExplain(input.next());
        System.out.println("请输入食品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);

        FoodDao dao = new FoodDaoImpl();
        int result = dao.saveFood(food);
        if(result>0) {
            System.out.println("\n新增食品成功！\n");
        }else {
            System.out.println("\n新增食品失败！\n");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
//        List<Food> list = showFoodList(businessId);
        List<Food> list = dao.findAll(businessId);
        if(list.size()==0) {
            System.out.println("没有任何食品！");
        }else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新食品价格(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(input.nextDouble());
            }

            int result = dao.updateFood(food);
            if(result>0) {
                System.out.println("\n修改食品成功！\n");
            }else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
            FoodDao dao = new FoodDaoImpl();
            List<Food> list = dao.findAll(businessId);

            if(list.size()==0) {
                System.out.println("没有任何食品！");
            }else {
                System.out.println("请选择要删除的食品编号：");
                int foodId = input.nextInt();

                System.out.println("确认要删除吗(y/n)：");
                if(input.next().equals("y")) {
                    int result = dao.removeFood(foodId);
                    if(result>0) {
                        System.out.println("\n删除食品成功！\n");
                    }else {
                        System.out.println("\n删除食品失败！\n");
                    }
                }
            }
    }
}
