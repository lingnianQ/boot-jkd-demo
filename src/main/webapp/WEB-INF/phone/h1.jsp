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

<div class="container" >
    <table border="1">
        <tr>
            <th>ID</th>
            <th>手机名</th>
            <th>图片</th>
            <th>价格</th>
            <th>介绍</th>
            <th>产品类型</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="row">
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

    <div class="page text-right clearfix" style="margin-top: 40px">
        <!-- 当前页为第一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件
                                        当前页不是第一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1
                                     -->
        <a <c:if test="${pageInfo.pageNum != pageInfo.firstPage}">href="${pageContext.request.contextPath}/p1/h2?currentPage=${pageInfo.pageNum - 1 }"</c:if>
                <c:if test="${pageInfo.pageNum == pageInfo.firstPage}"> href="javascript:void(0)" class="disabled"</c:if>
        >上一页</a>
        <!-- foreach 从 1 开始 到 总页数结束  遍历输出 -->
        <c:forEach begin="1" end="${pageInfo.pages }" varStatus="status">
            <a href="${pageContext.request.contextPath}/p1/h2?currentPage=${status.count }"
               <c:if test="${status.count == pageInfo.pageNum}">class="select"</c:if>>${status.count }</a>
        </c:forEach>
        <!-- 当前页为最后一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件
                                        当前页不是最后一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1
                                     -->
        <a <c:if test="${pageInfo.pageNum == pageInfo.lastPage}">class="disabled" href="javascript:void(0)"</c:if>
           <c:if test="${pageInfo.pageNum != pageInfo.lastPage}">href="${pageContext.request.contextPath}/p1/h2?currentPage=${pageInfo.pageNum + 1 }"</c:if>
        >下一页</a>
    </div>

<%--<div class="container" >--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>手机名</th>--%>
<%--            <th>图片</th>--%>
<%--            <th>价格</th>--%>
<%--            <th>介绍</th>--%>
<%--            <th>产品类型</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${phoneList}" var="row">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${row.id}"/></td>--%>
<%--                <td><c:out value="${row.phoneName}"/></td>--%>
<%--                <td><c:out value="${row.urls}"/></td>--%>
<%--                <td><c:out value="${row.price}"/></td>--%>
<%--                <td><c:out value="${row.remark}"/></td>--%>
<%--                <td><c:out value="${row.phoneTypeId}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--    <hr>--%>

<%--    <div class="text-center">--%>
<%--        <nav>--%>
<%--            <ul class="pagination">--%>
<%--                <li><a href="<c:url value="/list?page=1"/>">首页</a></li>--%>
<%--                <li><a href="<c:url value="/list?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>--%>

<%--                <c:forEach begin="1" end="${totalPages}" varStatus="loop">--%>
<%--                    <c:set var="active" value="${loop.index==page?'active':''}"/>--%>
<%--                    <li class="${active}"><a--%>
<%--                            href="<c:url value="/list?page=${loop.index}"/>">${loop.index}</a>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--                <li>--%>
<%--                    <a href="<c:url value="/list?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>--%>
<%--                </li>--%>
<%--                <li><a href="<c:url value="/list?page=${totalPages}"/>">尾页</a></li>--%>
<%--            </ul>--%>
<%--        </nav>--%>
<%--    </div>--%>
<%--</div>--%>



</body>
</html>
