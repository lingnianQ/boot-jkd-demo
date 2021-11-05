<%--
  Created by IntelliJ IDEA.
  User: sytsn
  Date: 2021/11/4
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jajaj</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>手机名</th>
        <th>图片</th>
        <th>价格</th>
        <th>介绍</th>
        <th>产品类型</th>
    </tr>
    <c:forEach items="${phoneList}" var="row">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.phoneName}"/></td>
            <td><c:out value="${row.urls}"/></td>
            <td><c:out value="${row.price}"/></td>
            <td><c:out value="${row.remark}"/></td>
            <td><c:out value="${row.phoneTypeId}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
