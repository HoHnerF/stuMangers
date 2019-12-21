<%@page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<form action="/login" method="post">
    账号：<input type="text" name="userName"><br>
    密码：<input type="password" name="passWord"><br>
    <p style="color: red">${message}</p><br>
    <input type="submit" value="登录">
</form>

</body>

</html>
