<%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-17
  Time: 下午2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>高级查询</title>
</head>
<body>
<h3 align="center">高级查询</h3>
<table border="1" width="70%" align="center">
    <form action="<c:url value="query.do"/>" method="post">
        <tr>
            <td>客户姓名：</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>客户性别：</td>
            <td>
                <input type="radio" name="gender" value="male" id="male"/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female"/>
                <label for="female">女</label>
            </td>
        </tr>
        <tr>
            <td>客户电话：</td>
            <td><input type="tel" name="phone"></td>
        </tr>
        <tr>
            <td>客户邮箱：</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>客户描述：</td>
            <td>
                <input type="text" name="description"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
