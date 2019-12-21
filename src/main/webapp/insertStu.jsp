
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<h1 align="center">添加学生信息</h1>
<form action="/insert" method="get">
    <table border="1" width="700px" align="center">
        <tr>
            <td>姓名</td>
            <td><input type="text" name = "name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="gender"></td>
        </tr>
        <tr>
            <td>国家</td>
            <td> <input type="text" name="address"></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>

</form>

</body>
</html>
