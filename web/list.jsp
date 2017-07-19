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
</body>
</html>
