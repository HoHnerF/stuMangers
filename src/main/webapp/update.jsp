<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<h1 align="center">修改学生信息</h1>
<form action="/updateServlet" method="get">
    <input type="hidden" name = "id" value="${student.id}">

    <table border="1" width="700px" align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="${student.name}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${student.age}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="gender" value="${student.gender}"></td>
            </tr>
            <tr>
                <td>国家</td>
                <td><input type="text" name="address" value="${student.address}"></td>
            </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"> <a href="/pageServlet?currentPage=${1}">返回</a></td>
        </tr>
    </table>
</form>

</body>
</html>
