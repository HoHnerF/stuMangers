package com.ge.servlet;

import com.ge.entity.Page;
import com.ge.entity.Student;
import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;
import static com.ge.dao.StuDao.PAGE_SIZE;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName: searchServlet <br/>
 * Description: <br/>
 * date: 2019/4/23 19:58<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */
@WebServlet("/search")
public class searchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");

            req.setAttribute("name",name);
            req.setAttribute("gender",gender);
            System.out.println(name+gender);
            StuService stuService = new StuServiceImpl();
            int currentPage = Integer.parseInt(req.getParameter("currentPage"));
            List<Student> list = stuService.search(name, gender,currentPage);
            Page page = new Page();
            page.setList(list);
            req.setAttribute("list",list);
            page.setPageSize(PAGE_SIZE);
            page.setCurrentPage(currentPage);
            List<Student> lists = stuService.searchCount(name, gender);
            page.setTotalSize(lists.size());
            page.setTotalPage(lists.size()%PAGE_SIZE == 0 ? lists.size()/PAGE_SIZE : (lists.size()/PAGE_SIZE+1));

            req.setAttribute("page",page);

            req.getRequestDispatcher("/search.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        doGet(req,resp);
    }
}
