<%--
  Created by IntelliJ IDEA.
  User: ZZS
  Date: 2020/8/9
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<c:if test="${error}!=null">
    <div style="color:#FF0000">
        登陆失败，错误信息：<c:out value="${error}"/>
    </div>
</c:if>
<form action="login">
    <div align="center">
        用户名：
        <input  type="text" name="name"/>
        <br>
        密码：
        <input  type="password" name="password"/>
        <input type="submit" value="登录">
    </div>

</form>
</body>
</html>
