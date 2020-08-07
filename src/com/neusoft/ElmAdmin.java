package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;
import com.neusoft.view.impl.AdminViewImpl;

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

        if (admin!=null){
            System.out.println("~欢迎来到饿了么商家管理系统~");
            //
        }

    }
}
