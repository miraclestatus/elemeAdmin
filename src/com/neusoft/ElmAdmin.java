package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.impl.AdminViewImpl;
import com.neusoft.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/7 11:30
 */
public class ElmAdmin {
    public static void main(String[] args) {
        work();
    }
    public static  void  work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用登录方法
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();

        BusinessView businessView = new BusinessViewImpl();
        if (admin!=null){
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu!= 5){

                // 创建一个菜单
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu){
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        System.out.println("1.搜索商家");
                        break;
                    case 3:
                        System.out.println("1.新建商家");
                        break;
                    case 4:
                        System.out.println("1.删除商家");
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
}
