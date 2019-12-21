<%@ page isELIgnored="false"%> <%--关于el标签不起作用--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>>学生管理系统</title>
</head>
<body>

<h1 style="text-align: center">学生管理系统</h1>
<form action="/search?currentPage=${1}" method="post">

    <p style="margin-left:1000px ">
        欢迎${userName}登录 访问量：${count}
    </p>
    <table border="1" width="700px" align="center">

        <tr style="text-align: center">

            <td colspan="5">
                姓名：<input type="text" name="name">
                性别：
                <select name="gender" size="1">
                    <option value="">--请选择--</option>
                    <option value="男" >男</option>
                    <option value="女" >女</option>
                    <input type="submit" value="查询">
                </select>
            <td><a href="/insertStu.jsp">添加</a></td>

            </td>
        </tr>

        <tr align="center">
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>国家</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="stu">
            <tr align="center">
                <td>${stu.id }</td>
                <td>${stu.name }</td>
                <td>${stu.age}</td>
                <td>${stu.gender }</td>
                <td>${stu.address}</td>
                <td><a href="/selectByID?id=${stu.id}">修改</a> <a href="/delete?id=${stu.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="6">
                第${page.currentPage}/${page.totalPage}页&nbsp;&nbsp;&nbsp;
                每页显示${page.pageSize}条数据&nbsp;&nbsp;&nbsp;
                总人数：${page.totalSize}&nbsp;&nbsp;&nbsp;
                <c:if test="${page.currentPage != 1}">
                    <a href="/pageServlet?currentPage=1">首页</a>|<a href="/pageServlet?currentPage=${page.currentPage-1}">上一页</a>&nbsp;&nbsp;
                </c:if>
                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${page.currentPage == i}">
                        ${i}
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <a href="/pageServlet?currentPage=${i}">${i}</a>

                    </c:if>
                </c:forEach>


                <c:if test="${page.currentPage != page.totalPage}">
                    <a href="/pageServlet?currentPage=${page.currentPage+1}">下一页</a>|<a href="/pageServlet?currentPage=${page.totalPage}">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
