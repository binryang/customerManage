<%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-17
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--在指定框架中打开被链接文档-->
    <base target="main">
    <title>客户管理系统</title>
</head>
<body style="text-align: center">
    <h1>客户关系管理系统</h1>
    <a href="<c:url value="add.jsp"/>">添加用户</a>
    <a href="<c:url value="queryall.do"/>">查询所有用户</a>
    <a href="<c:url value="query.jsp"/>">高级查询</a>
</body>
</html>
