<%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-17
  Time: 下午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>消息提示</title>
</head>
<body>
<h3 align="center">消息提示</h3>
<c:if test="${msg!=null}">
    <h4 align="center">${msg}</h4>
</c:if>
</body>
</html>
