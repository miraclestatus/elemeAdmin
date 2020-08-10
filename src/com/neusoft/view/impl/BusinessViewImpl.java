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

    /**
     * 保存商家
     */
    @Override
    public void saveBusiness() {
        System.out.println("请输入商家名字：");
        String businessName = input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        if (businessId > 0){
            System.out.println("新建商家成功！ 商家编号为" + businessId);

        }else{
            System.out.println("新建商家失败！" );

        }

    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入商家编号：");
        int businessId = input.nextInt();

        BusinessDao dao = new BusinessDaoImpl();
        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = dao.removeBusiness(businessId);
            if(result==1) {
                System.out.println("删除商家成功！");
            }else {
                System.out.println("删除商家失败！");
            }
        }
    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号：");
        Integer businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();


        return dao.getBusinessByNameByPass(businessId, password);
    }

    @Override
    public void showBusinessInfo(Integer businessId) {
        // 调用dao
        BusinessDaoImpl dao = new BusinessDaoImpl();
//        dao.g
        Business business = dao.getBusinessByBusinessId(businessId);
        System.out.println(business);
    }

    @Override
    public void updateBusinessInfo(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessByBusinessId(businessId);
        // 先显示一遍商家信息， 方便用户查看修改
        String inputStr = "";
        System.out.println(business);
        System.out.println("是否修改商家名称(y/n");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的商家名称");
            business.setBusinessName(input.next());
        }
        // TODO
        // 一些列的更新

        // dao.updateBusiness(business);
        int res = dao.updateBusiness(business);
        if(res > 0)
            System.out.println("修改商家信息成功");
        else
            System.out.println("修改商家信息失败");
    }
}
