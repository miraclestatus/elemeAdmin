package com.neusoft.test;

import com.neusoft.dao.Impl.BusinessDaoImpl;

/**
 * @author Eric Lee
 * @date 2020/8/7 15:01
 */
public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
//        dao.listBusiness(null,  "沈阳");
        dao.listBusiness(null,  null);
    }
}
