package com.ge.service;

import com.ge.dao.StuDao;
import com.ge.dao.StuDaoImpl;
import com.ge.entity.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: StuServiceImpl <br/>
 * Description: <br/>
 * date: 2019/4/23 1:18<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
public class StuServiceImpl implements StuService{
    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.findStudentByPage(currentPage);

    }

    @Override
    public int findStuCount() throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();

        return stuDao.findStuCount();
    }

    @Override
    public void deleteByID(int id) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.deleteByID(id);
    }

    @Override
    public void insert(String name, int age, String gender, String address) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.insert(name, age, gender, address);

    }

    @Override
    public Student selectByID(int id) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.selectByID(id);
    }

    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.update(student);

    }

    @Override
    public List<Student> searchCount(String name, String gender) throws SQLException, ClassNotFoundException {
        return  new StuDaoImpl().searchCount(name, gender);
    }

    @Override
    public List<Student> search(String name, String gender,int currentPage) throws SQLException, ClassNotFoundException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.search(name, gender, currentPage);
    }


}
