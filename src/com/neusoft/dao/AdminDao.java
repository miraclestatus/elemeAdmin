package com.neusoft.dao;

import com.neusoft.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
}
