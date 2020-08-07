package com.neusoft.view.impl;

import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/7 15:18
 */
public class BusinessViewImpl implements BusinessView {

    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称");
        for (Business b :list){
            System.out.println(b.getBusinessId()+ "\t" + b.getBusinessName());
        }
    }
}
