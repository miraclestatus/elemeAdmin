package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.impl.AdminViewImpl;
import com.neusoft.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/10 09:04
 */
public class ElmBusiness {
    private static  Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
       work();
    }

    public static  void  work(){

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用商家登录
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();

        if (business!=null){
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu!= 5){

                // 创建一个菜单
                System.out.println("========= 一级菜单1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu){
                    case 1:
                        businessView.showBusinessInfo(business.getBusinessId());
                        break;
                    case 2:
                        businessView.updateBusinessInfo(business.getBusinessId());
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        foodManage(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }


        }else {
            System.out.println("账号或密码有误请重新输入");
        }

    }

    private  static  void foodManage(int businessId){
        int menu = 0;
        while (menu!= 5){

            // 创建一个菜单
            System.out.println("========= 二级菜单（美食管理）1.查看食品列表2.新增食品 3.修改食品=4.删除食品=5.返回一级菜单 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();

            switch (menu){
                case 1:
                    System.out.println("查看食品列表");
                    break;
                case 2:
                    System.out.println("新增食品");

                    break;
                case 3:
                    System.out.println("修改食品");

                    break;
                case 4:
                    System.out.println("删除食品");

                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }

        }

    }
}
