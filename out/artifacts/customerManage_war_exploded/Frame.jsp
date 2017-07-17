<%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-17
  Time: 下午1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<frameset rows="25%,*">
    <frame src="<c:url value="/top.jsp"/>" name="top"/>
    <frame src="<c:url value="/welcome.jsp"/>" name="main"/>
</frameset>
</html>