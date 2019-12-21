package com.ge.dao;

import com.ge.entity.Student;
import com.ge.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: StuDaoImpl <br/>
 * Description: <br/>
 * date: 2019/4/23 0:55<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
public class StuDaoImpl implements StuDao{
    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from t_stu limit ? offset ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setObject(1,PAGE_SIZE);
        pre.setObject(2, (currentPage-1)*PAGE_SIZE);
        ResultSet rs = pre.executeQuery();
        List<Student> list = new ArrayList<Student>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            Student student = new Student(id,name,age,gender,address);
            list.add(student);
        }
        JdbcUtil.release(pre,conn,rs);
        return list;
    }

    @Override
    public int findStuCount() throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) from t_stu";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        int count = 0 ;
        while(rs.next()){
            count = rs.getInt(1);
        }

        JdbcUtil.release(pre, conn,rs);
        return count;
    }

    @Override
    public void deleteByID(int id) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "delete from t_stu where id = ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1,id);
        pre.executeUpdate();
        JdbcUtil.release(conn,pre);
    }

    @Override
    public void insert(String name, int age, String gender, String address) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "insert into t_stu(name,age,gender,address) values(?,?,?,?) ";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,name);
        pre.setInt(2,age);
        pre.setString(3,gender);
        pre.setString(4,address);
        pre.executeUpdate();
        JdbcUtil.release(conn,pre);
    }

    @Override
    public Student selectByID(int id) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from t_stu where id = ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1,id);
        ResultSet rs = pre.executeQuery();
        rs.next();
        Student student = new Student(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
        JdbcUtil.release(pre, conn, rs);
        return student;
    }

    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "update t_stu set name = ?, age = ?, gender = ?, address = ? where id = ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,student.getName());
        pre.setInt(2,student.getAge());
        pre.setString(3,student.getGender());
        pre.setString(4,student.getAddress());
        pre.setInt(5,student.getId());
        pre.executeUpdate();
        JdbcUtil.release(conn,pre);
    }

    @Override
    public List<Student> searchCount(String name, String gender) throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<Student>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from t_stu where  1=1 ";
        if(!("".equals(name))){
            sql = sql + "and name = '"+name+"'";
        }
        if(!("".equals(gender))){
            sql = sql + "and gender = '"+gender+"'";
        }
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()){
            Student student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            list.add(student);
        }
        return list;
    }

    @Override
    public List<Student> search(String name, String gender,int currentPage) throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<Student>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from t_stu where 1=1 ";

        if(!("".equals(name))){
            sql=sql+" and name = '"+name+"'";
        }
        if(!("".equals(gender))){
            sql = sql+" and gender ='"+gender+"' ";
        }
        sql = sql+"limit "+PAGE_SIZE+" offset "+(currentPage-1)*PAGE_SIZE+" ";
        System.out.println(sql);
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()){
            Student student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            list.add(student);
        }
        JdbcUtil.release(pre, conn, rs);
        return list;
    }


}
