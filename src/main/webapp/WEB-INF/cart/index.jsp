<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: sytsn
  Date: 2021/11/13
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/boot/plugins/bs/css/bootstrap.min.css">
    <style>
        #outer img{
            width: 80px;
            height: 80px;
        }
    </style>
    <script src="/boot/plugins/jquery/jquery.min.js"></script>
</head>
<body>
<%--    jsp指令--%>
<%@ include file="../common/nav.jsp"%>

<%=new Date()%>

<div class="container">
    <div class="row">
        <div class="table-responsive">
            <table class="table">
                <caption>响应式表格布局</caption>
                <thead>
                <tr>
                    <th><input type="checkbox"> </th>
                    <th>序号</th>
                    <th>产品名</th>
                    <th>产品图</th>
                    <th>单价</th>
                    <th>购买数量</th>
                    <th>总价</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="outer">
                <c:forEach items="${pageInfo.list}" var="c" varStatus="vs">
                    <tr>
                        <td><input type="checkbox"> </td>
                        <td>${vs.count}</td>
                        <td>${c.name}</td>
                        <td><img src="/boot/imgs/${c.url}"></td>
                        <td>${c.price}</td>
                        <td>${c.num}</td>
                        <td>${c.total}</td>
                        <td>
                            <button onclick="del_cart(this,${c.id})" type="button" class="btn btn-link">
                                <span class="text-danger glyphicon glyphicon-trash"></span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="page text-center clearfix" >
    <%--     当前页为第一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件--%>
    <%--                                        当前页不是第一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1--%>
    <a      <c:if test="${pageInfo.pageNum == pageInfo.firstPage}"> href="javascript:void(0)" class="disabled"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.firstPage;empty name}">href="${pageContext.request.contextPath}/cart/index?currentPage=${pageInfo.pageNum - 1 }"</c:if>
    ><strong class="h1">上一页</strong></a>
    <!-- foreach 从 1 开始 到 总页数结束  遍历输出 -->
    <c:forEach begin="1" end="${pageInfo.pages }" varStatus="status">
        <a <c:if test="${pageInfo.pageNum != pageInfo.firstPage;empty name}">href="${pageContext.request.contextPath}/cart/index?currentPage=${status.count }"</c:if>
           <c:if test="${status.count == pageInfo.pageNum}">class="select"</c:if>><strong class="h1">${status.count }</strong></a>
    </c:forEach>
    <%--   当前页为最后一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件--%>
    <%--                                        当前页不是最后一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1--%>

    <a      <c:if test="${pageInfo.pageNum == pageInfo.lastPage}">class="disabled" href="javascript:void(0)"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.lastPage;empty name}">href="${pageContext.request.contextPath}/cart/index?currentPage=${pageInfo.pageNum + 1 }"</c:if>
    ><strong class="h1">下一页</strong></a>
    <%--    <button type="button" onclick="pageNext()">1234</button>--%>
</div>



<script src="/boot/plugins/bs/js/bootstrap.min.js"></script>
<script>
    function del_cart(obj,id){
        $.post('/boot/cart/del',{id:id},function(res){
            if(res.code==200){
                //js操作dom - js删除tr
                $(obj).parent().parent().remove();
            }
        })
    }
</script>
</body>
</html>

