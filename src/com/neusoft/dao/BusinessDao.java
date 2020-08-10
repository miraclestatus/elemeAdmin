package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    // 显示所有商家列表  可选输入businessName和businessAddress
    public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);


    public Business getBusinessByNameByPass(Integer businessId, String password);

}
