<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: yangrb
  Date: 17-7-19
  Time: 下午4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<h3 align="center">编辑用户</h3>
<c:if test="${msg!=null}">
    <h3 align="center">${msg}</h3>
</c:if>
<table border="1" width="70%" align="center">
    <form action="<c:url value="update.do"/>" method="post">
        <input type="hidden" name="id" value="${param.id==null?"":param.id}"/>
        <input type="hidden" name="oldname" value="${editcustomer.name==null?"":editcustomer.name}"/>
        <tr>
            <td>客户姓名：</td>
            <td>
                <input type="text" name="name" value="${editcustomer.name==null?"":editcustomer.name}"/>
            </td>
        </tr>
        <tr>
            <td>客户性别：</td>
            <td>
                <input type="radio" name="gender" value="male" id="male" <c:if test="${editcustomer.gender eq 'male'}">checked="checked"</c:if>/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female" <c:if test="${editcustomer.gender eq 'female'}">checked="checked"</c:if>/>
                <label for="female">女</label>
            </td>
        </tr>
        <tr>
            <td>客户电话：</td>
            <td><input type="tel" name="phone" value="${editcustomer.phone==null?"":editcustomer.phone}"/></td>
        </tr>
        <tr>
            <td>客户邮箱：</td>
            <td><input type="email" name="email" value="${editcustomer.email==null?"":editcustomer.email}"/></td>
        </tr>
        <tr>
            <td>客户描述：</td>
            <td>
                <input type="text" name="description" value="${editcustomer.description==null?"":editcustomer.description}"/>
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
