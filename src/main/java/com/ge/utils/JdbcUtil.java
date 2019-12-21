package com.ge.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    private static String driverClass;
    private static String url;
    private static String userName;
    private static String passWord;


    static {
        try {
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("datebase.properties");
            Properties pro = new Properties();
            pro.load(in);
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            userName = pro.getProperty("userName");
            passWord = pro.getProperty("passWord");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        return connection;
    }

    /**
     * 释放资源
     *
     */
    //这里用父类Statement应用多态 即使传过来的PrepareStatement子类也能
    public static void release(Statement sta, Connection conn, ResultSet rs) {
        closeRs(rs);
        closeSta(sta);
        closeConn(conn);

    }
    public static void release(Connection conn, Statement sta){
        closeConn(conn);
        closeSta(sta);
    }

    public static void closeRs(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeSta(Statement sta){
        try {
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConn(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
