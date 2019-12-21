package com.ge.dao;

import com.ge.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{
    @Override
    public Boolean login(String userName ,String passWord) {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs =null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            pre = conn.prepareStatement(sql);
            pre.setObject(1, userName);
            pre.setObject(2, passWord);
            rs = pre.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(pre, conn, rs);
        }
        return false;
    }
}
