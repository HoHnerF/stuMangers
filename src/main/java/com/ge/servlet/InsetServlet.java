package com.ge.servlet;

import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * ClassName: InsetServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 12:18<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
@WebServlet("/insert")
public class InsetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String gender = req.getParameter("gender");
            String address = req.getParameter("address");
            StuService stuService = new StuServiceImpl();
            stuService.insert(name,age,gender,address);
            req.getRequestDispatcher("/pageServlet?currentPage=1").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
