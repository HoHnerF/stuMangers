package com.ge.servlet;

import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ClassName: SelectByIDServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 17:02<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
@WebServlet("/selectByID")
public class SelectByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            StuService stuService = new StuServiceImpl();
            req.setAttribute("student",stuService.selectByID(id));
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req,resp);
    }
}
