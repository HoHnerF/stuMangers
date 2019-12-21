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
 * ClassName: DeleteServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 9:39<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StuService stuService = new StuServiceImpl();
        try {
            stuService.deleteByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/pageServlet?currentPage=1").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
