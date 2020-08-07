package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/7 15:18
 */
public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }
    }

    /**
     * 搜索
     */
    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否需要输入商家名称关键字(y/n): ");
        inputStr = input.next();
        if(inputStr.equals("y")){
            System.out.println("请输入商家名称关键字：");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(y/n): ");
        inputStr = input.next();
        if(inputStr.equals("y")){
            System.out.println("请输入商家地址关键字：");
            businessAddress = input.next();
        }

        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }

    }
}
