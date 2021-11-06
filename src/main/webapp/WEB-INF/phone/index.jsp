<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <title>表</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/boot/plugins/bs/css/bootstrap.min.css">
    <style>
        #phone img{
            width: 200px;
        }
    </style>
    <script src="/boot/plugins/jquery/jquery.min.js"></script>
</head>
<body>

<%--    jsp指令--%>
<%@ include file="../common/nav.jsp"%>

<%--    ${作用域中的key}--%>
<div class="container-fluid" id="phone">
    <div class="row">
        <c:forEach items="${phoneList}" var="p">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src="/boot/imgs/${p.urls}"
                         alt="通用的占位符缩略图">
                    <div class="caption">
                        <h3 class="text-center text-info">${p.phoneName}</h3>
                        <p class="text-center text-danger">价格:${p.price}</p>
                        <p class="text-success">${p.remark}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%--    <table border="1" width="500px" style="margin: 2px">--%>
<%--        <caption>t_phone</caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>手机名</th>--%>
<%--            <th>图片</th>--%>
<%--            <th>价格</th>--%>
<%--            <th>介绍</th>--%>
<%--            <th>产品类型</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="phone" items="${phoneList}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${phone.id}"/></td>--%>
<%--                <td><c:out value="${phone.phoneName}"/></td>--%>
<%--                <td><c:out value="${phone.urls}"/></td>--%>
<%--                <td><c:out value="${phone.price}"/></td>--%>
<%--                <td><c:out value="${phone.remark}"/></td>--%>
<%--                <td><c:out value="${phone.phoneTypeId}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<br>
<br>
<%--    --%>
<%--    <table border="1" width="100px" style="margin: 2px">--%>
<%--        <caption>phone_type</caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>手机类型</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="row" items="${phonetypename.rows}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${row.id}"/></td>--%>
<%--                <td><c:out value="${row.phoneTypeName}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<br>
<br>

<%--    <table border="1" width="500px" style="margin: 2px">--%>
<%--        <caption>t_phone,phone_type</caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>手机名</th>--%>
<%--            <th>图片</th>--%>
<%--            <th>价格</th>--%>
<%--            <th>介绍</th>--%>
<%--            <th>产品类型</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="row" items="${phonetype.rows}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${row.id}"/></td>--%>
<%--                <td><c:out value="${row.phoneName}"/></td>--%>
<%--                <td><c:out value="${row.urls}"/></td>--%>
<%--                <td><c:out value="${row.price}"/></td>--%>
<%--                <td><c:out value="${row.remark}"/></td>--%>
<%--                <td><c:out value="${row.phoneTypeName}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<br>
<br>

<script src="/boot/plugins/bs/js/bootstrap.min.js"></script>
</body>
</html>
