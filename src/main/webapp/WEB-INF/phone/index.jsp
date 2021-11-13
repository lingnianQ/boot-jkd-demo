<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>小米商城</title>
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

<div class="container">
    <div class="row">
        <form class="bs-example bs-example-form" role="form">
            <div class="row">
                <div class="col-md-offset-3 col-lg-6">
                    <div class="input-group">
                        <input type="text" id="phoneName" class="form-control" value="${name}" placeholder="请您输入产品名称">
                        <span class="input-group-btn">
                                 <button class="btn btn-success" type="button" onclick="search()">Search</button>
                            </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
        </form>
    </div>
</div>

<%--    ${作用域中的key}--%>
<div class="container-fluid" id="phone">
    <div class="row">
        <c:forEach items="${pageInfo.list}" var="p">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src="/boot/imgs/${p.urls}"
                         alt="通用的占位符缩略图">
                    <div class="caption">
                        <h3 class="text-center text-info">${p.phoneName}</h3>
                        <p class="text-center text-danger">价格:${p.price}</p>
                        <p class="text-success text-center" >${p.remark}</p>
                    </div>
                    <div>
                        <a href="javascript:add_cart(${p.id})"><span class="glyphicon glyphicon-shopping-cart"></span></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div class="page text-center clearfix" >
<%--     当前页为第一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件--%>
<%--                                        当前页不是第一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1--%>
    <a      <c:if test="${pageInfo.pageNum == pageInfo.firstPage}"> href="javascript:void(0)" class="disabled"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.firstPage;empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${pageInfo.pageNum - 1 }"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.firstPage;not empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${pageInfo.pageNum - 1 }&name=${name}"</c:if>
    ><strong class="h1">上一页</strong></a>
    <!-- foreach 从 1 开始 到 总页数结束  遍历输出 -->
    <c:forEach begin="1" end="${pageInfo.pages }" varStatus="status">
        <a <c:if test="${pageInfo.pageNum != pageInfo.firstPage;empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${status.count }"</c:if>
           <c:if test="${pageInfo.pageNum != pageInfo.firstPage;not empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${status.count}&name=${name}"</c:if>
           <c:if test="${status.count == pageInfo.pageNum}">class="select"</c:if>><strong class="h1">${status.count }</strong></a>
    </c:forEach>
<%--   当前页为最后一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件--%>
<%--                                        当前页不是最后一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1--%>

    <a      <c:if test="${pageInfo.pageNum == pageInfo.lastPage}">class="disabled" href="javascript:void(0)"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.lastPage;empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${pageInfo.pageNum + 1 }"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.lastPage;not empty name}">href="${pageContext.request.contextPath}/phone/index?currentPage=${pageInfo.pageNum + 1 }&name=${name}"</c:if>
    ><strong class="h1">下一页</strong></a>
<%--    <button type="button" onclick="pageNext()">1234</button>--%>
</div>

    <script src="/boot/plugins/bs/js/bootstrap.min.js"></script>
    <script>
        function search(){
            let phoneName = $("#phoneName").val();
            window.location='/boot/phone/index?currentPage=1&'+'name='+phoneName;
        }
        function add_cart(id){
            //通过ajax技术
            $.post('/boot/cart/add',{id:id},function(res){
                if(res.code==200){
                    alert("添加购物车成功");
                }else{
                    alert("添加购物车失败");
                }
            })
        }
    </script>
</body>
</html>
