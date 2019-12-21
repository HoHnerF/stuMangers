package com.ge.dao;

import com.ge.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StuDao {
      int PAGE_SIZE = 5;

      List<Student> findStudentByPage(int currentPage) throws SQLException, ClassNotFoundException;

      int findStuCount() throws SQLException, ClassNotFoundException;

      void deleteByID(int id) throws SQLException, ClassNotFoundException;

      void insert(String name,int age,String gender,String address) throws SQLException, ClassNotFoundException;

      Student selectByID(int id) throws SQLException, ClassNotFoundException;

      void update(Student student) throws SQLException, ClassNotFoundException;

      List<Student> searchCount(String name,String gender) throws SQLException, ClassNotFoundException;

      List<Student> search(String name,String gender,int currentPage) throws SQLException, ClassNotFoundException;
}
