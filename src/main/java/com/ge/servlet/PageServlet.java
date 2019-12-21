package com.ge.servlet;

import com.ge.entity.Page;
import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.ge.dao.StuDao.PAGE_SIZE;

/**
 * ClassName: PageServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 9:11<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        try {
            int currentPage = Integer.parseInt(req.getParameter("currentPage"));
            Page page = new Page();
            StuService stuService = new StuServiceImpl();
            page.setList(stuService.findStudentByPage(currentPage));
            page.setCurrentPage(currentPage);
            page.setTotalPage(stuService.findStuCount() % PAGE_SIZE ==0 ? stuService.findStuCount() / PAGE_SIZE : (stuService.findStuCount()/PAGE_SIZE+1));
            page.setPageSize(PAGE_SIZE);

            page.setTotalSize(stuService.findStuCount());
            req.setAttribute("list",page.getList());
            req.setAttribute("page",page);
            req.getRequestDispatcher("stu.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
