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
    <title>我的购物车</title>
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
                    <th><input type="checkbox" id="SelectAll" onclick="selectAll()"></th>
                    <th>序号</th>
                    <th>产品名</th>
                    <th>产品图</th>
                    <th>单价</th>
                    <th></th>
                    <th class="text-center">购买数量</th>
                    <th></th>
                    <th>总价</th>
                    <th>
                        <button onclick="allDel()" type="button" class="btn btn-link">
                            <span class="text-danger glyphicon glyphicon-trash">删除选中</span>
                        </button>
                    </th>
                </tr>
                </thead>
                <tbody id="outer">
                <c:forEach items="${pageInfo.list}" var="c" varStatus="vs">
                    <tr>
                        <td><input type="checkbox" name="ck" value="${c.id}"></td>
                        <td>${vs.count}</td>
                        <td>${c.name}</td>
                        <td><img src="/boot/imgs/${c.url}"></td>
                        <td>${c.price}</td>
                        <td class="text-right">
                            <a <c:if test="${c.num>1}">
                                    href="javascript:sup_cart(${c.id})">
                                </c:if>
                                <span class="glyphicon glyphicon-minus"></span>
                            </a>
                        </td>
                        <td class="text-center" id="num">
                            ${c.num}
                        </td>
                        <td class="text-left">
                            <a href="javascript:add_cart(${c.id})">
                                <span class="glyphicon glyphicon-plus"></span>
                            </a>
                        </td>
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
            <c:if test="${pageInfo.pageNum != pageInfo.firstPage}">href="${pageContext.request.contextPath}/cart/index?currentPage=${pageInfo.pageNum - 1 }"</c:if>
    ><strong class="h1">上一页</strong></a>
    <!-- foreach 从 1 开始 到 总页数结束  遍历输出 -->
    <c:forEach begin="1" end="${pageInfo.pages }" varStatus="status">
        <a <c:if test="${not empty pageInfo.pageNum}">href="${pageContext.request.contextPath}/cart/index?currentPage=${status.count }"</c:if>
           <c:if test="${status.count == pageInfo.pageNum}">class="select"</c:if>><strong class="h1">${status.count }</strong></a>
    </c:forEach>
    <%--   当前页为最后一页时href="javascript:void(0)" 禁用 a 标签的点击时间事件--%>
    <%--                                        当前页不是最后一页时请求url 中返回currentPage=${pageInfo.pageNum - 1 } 当前页 -1--%>
    <a      <c:if test="${pageInfo.pageNum == pageInfo.lastPage}">class="disabled" href="javascript:void(0)"</c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.lastPage}">href="${pageContext.request.contextPath}/cart/index?currentPage=${pageInfo.pageNum + 1 }"</c:if>
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
    function sup_cart(id){
        $.post('/boot/cart/supCart',{id:id},function(res){
            if(res.code==200){
                window.location.reload();
            }
        })
    }
    function add_cart(id){
        $.post('/boot/cart/addCart',{id:id},function(res){
            if(res.code==200){
                window.location.reload();
            }
        })
    }
    //全选
    function selectAll(){
        let ck=document.getElementsByName("ck");//得到一组checkbox  相当于数组
        let cak=document.getElementById("SelectAll");
        if(cak.checked==true){
            //循环这一组checkbox让每一个checkbox选中
            for(let i=0;i<ck.length;i++){
                let c=ck[i];//得到一个checkbox
                c.checked=true;//false代表不选
            }
        }
        else{
            for(let i=0;i<ck.length;i++){
                let c=ck[i];//得到一个checkbox
                c.checked=false;//false代表不选
            }
        }
    }
    //批量删除
    function allDel(){
        // $.post('/boot/cart/allDel',{id:id},function(res){
        //         window.location.reload();
        // })
        let checkedNum = $("input[name='ck']:checked").length;
        if(checkedNum==0){
            alert("请至少选择一项!");
            return false;
        }
        if(confirm("确定删除所选项目?")){
            let checkedList = new Array();
            $("input[name='ck']:checked").each(function(){
                checkedList.push($(this).val());
            });
            $.ajax({
                type:"POST",
                url:"/boot/cart/allDel",
                data:{"delitems":checkedList.toString()},
                datatype:"html",
                success:function(data){
                    alert("删除成功！");
                    window.location.reload();
                },
                error:function(data){
                    alert("删除失败！");
                    window.location.reload();
                }
            });
        }
    }
</script>
</body>
</html>

