package com.ge.dao;

import java.sql.SQLException;

public interface UserDao {
    //登录
    public Boolean login(String userName, String passWord) throws SQLException, ClassNotFoundException;
}
