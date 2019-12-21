package com.ge.servlet;

import com.ge.dao.UserDao;
import com.ge.dao.UserDaoImpl;
import com.ge.entity.Page;
import com.ge.service.StuService;
import com.ge.service.StuServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.ge.dao.StuDao.PAGE_SIZE;
/**
 * ClassName: loginServlet <br/>
 * Description: <br/>
 * date: 2019/4/22 23:53<br/>
 *
 * @author gwj<br />
 * @since JDK 1.8
 */

@WebServlet("/login")
public class loginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        UserDao userDao = new UserDaoImpl();
        try {
            Boolean isSucess = userDao.login(userName, passWord);
            if(isSucess){
                //统计访问量
                ServletContext servletContext = this.getServletContext();
                Integer count = (Integer) servletContext.getAttribute("count");
                if(count==null){
                    count=1;
                    servletContext.setAttribute("count",count);
                }else{
                    servletContext.setAttribute("count",++count);
                }

                Page page = new Page();
                StuService stuService = new StuServiceImpl();
                page.setList(stuService.findStudentByPage(1));
                req.getSession().setAttribute("userName", req.getParameter("userName"));
                page.setCurrentPage(1);
                page.setPageSize(PAGE_SIZE );
                page.setTotalSize(stuService.findStuCount());
                page.setTotalPage(stuService.findStuCount() % PAGE_SIZE == 0 ? stuService.findStuCount()/PAGE_SIZE : (stuService.findStuCount()/PAGE_SIZE+1));
                req.setAttribute("page",page);
                req.setAttribute("list",page.getList());
                req.getRequestDispatcher("stu.jsp").forward(req,resp);

            }else{
                req.setAttribute("message","密码错误,请重新输入");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
