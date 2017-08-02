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
<script type="text/javascript">
    function del(param) {
        var fdel = window.confirm("确定删除？");
        if (fdel){
            document.location="delete.do?id="+param;
        }
    }
    function edit(param) {
        document.location="edit.do?id="+param;
    }
</script>
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
                <input type="button" name="编辑" value="编辑" onclick="edit(${cstm.id})"/>
                <input type="button" name="删除" value="删除" onclick="del(${cstm.id})"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<div align="center">
    共${pagenum}页     当前 第${page}页
    <c:choose>
        <c:when test="${page>1}">
            <a href="<c:url value="queryall.do?page=${page-1}"></c:url> "><input type="button" value="上一页"/></a>
        </c:when>
        <c:otherwise>
            <input type="button" value="上一页" disabled="disabled"/>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${page!=pagenum}">
            <a href="<c:url value="queryall.do?page=${page+1}"></c:url> "><input type="button" value="下一页"/></a>
        </c:when>
        <c:otherwise>
            <input type="button" value="下一页" disabled="disabled"/>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
