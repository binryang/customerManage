<%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-17
  Time: 下午6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
</head>
<body>
<h3 align="center" >客户列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>客户姓名</th>
        <th>性别</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${customers}" var="cstm">
        <tr>
            <td>${cstm.name}</td>
            <td>${cstm.gender}</td>
            <td>${cstm.phone}</td>
            <td>${cstm.email}</td>
            <td>${cstm.description}</td>
            <td>
                <a href="<c:url value='edit.do?id=${cstm.id}'/> ">编辑</a>
                <a href="<c:url value='delete.do?id=${cstm.id}'/> ">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
