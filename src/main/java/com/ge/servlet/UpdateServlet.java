package com.ge.servlet;

import com.ge.entity.Student;
import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ClassName: UpdateServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 16:58<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        try {
            Student student = new Student(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),Integer.parseInt(req.getParameter("age")),req.getParameter("gender"),req.getParameter("address"));
            StuService stuService = new StuServiceImpl();
            stuService.update(student);

            req.getRequestDispatcher("/pageServlet?currentPage=1").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req,resp);
    }
}


