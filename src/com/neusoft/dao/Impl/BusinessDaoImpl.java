package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/7 14:52
 */
public class BusinessDaoImpl implements BusinessDao {
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%' ");
        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了商家名
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");
        }
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return list;
    }

    @Override
    public int saveBusiness(String businessName) {
        int businessId = 0;
        // 附带一个初始密码
        String sql = "insert into business(businessName, password)values(?, '123456')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // 可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, businessName);
            pstmt.executeUpdate();
            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                businessId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return businessId;
    }

    @Override
    public Business getBusinessByNameByPass(Integer businessId, String password) {
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return business;
    }

    @Override
    public int removeBusiness(int businessId) {
        // 删除的时候注意需要开启事物
        int result = 0;
        String sql = "delete from business where businessId = ?";

        try{
            conn = JDBCUtils.getConnection();
            // 手动开启事物
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            result = pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            // 进入了异常的代码区要给result置为 0
            result = 0;
            try {
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();


        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return result;
    }


}
