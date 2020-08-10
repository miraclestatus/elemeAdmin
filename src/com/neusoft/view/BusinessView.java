package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void removeBusiness();

    // 添加一个商家登录验证的方法
    public Business login();

}
