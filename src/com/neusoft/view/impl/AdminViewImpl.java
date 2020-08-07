package com.neusoft.view.impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;

import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/7 11:35
 */
public class AdminViewImpl implements AdminView {
    private  Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入管理员的用户名：");
        String adminName = input.next();
        System.out.println("请输入管理员的密码：");
        String password = input.next();
        AdminDao dao = new AdminDaoImpl();
//        Admin admin = dao.getAdminByNameByPass(adminName, password);
//        return admin;
        return dao.getAdminByNameByPass(adminName, password);
    }
}
