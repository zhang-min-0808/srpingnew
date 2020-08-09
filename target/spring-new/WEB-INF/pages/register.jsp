<%--
  Created by IntelliJ IDEA.
  User: ZZS
  Date: 2020/8/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1 align="center">欢迎登录员工管理系统</h1>
<c:if test="${error}!=null">
    <div style="color:#FF0000">
        <c:out value="${error}"/>
    </div>
</c:if>
<br><br><br><br><br><br><br><br><br><br><br><br>
<div align="center">
    <form action="register">
        用户名：
        <input type="text" name="name"/>
        </BR>
        密码：
        <input type="password" name="password"/>
        </BR>
        邮箱：
        <input type="text" name="email"/>
        <br>
        手机号码：
        <input type="text" name="phone"/>
        <br>
        年龄
        <input type="text" name="age"/>
        <br>
        角色：
        <input type="radio" name="role" value="COMMON" checked="checked">普通员工</input>
        <input type="radio" name="role" value="ADMIN">系统管理员</input>
        </br>
        <input type="submit" value="提交"/>
    </form>

</div>


</body>
<head>
    <title>注册页面</title>
</head>
</html>
