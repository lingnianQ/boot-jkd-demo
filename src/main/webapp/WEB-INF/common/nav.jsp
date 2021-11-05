<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/30
  Time: 2:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">小米商城</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal">登录</a></li>
                <li><a href="#">注册</a></li>
                <li><a href="#">安全退出</a></li>
                <li><a href="#">我的购物车</a></li>
                <li><a href="#">我的订单</a></li>
                <li><a href="#">我的收藏</a></li>
                <li><img style="width: 50px;height: 50px;border-radius: 50%;padding: 2px" src="/boot/imgs/1.jpg" alt="1"></li>
            </ul>
        </div>
    </div>
</nav>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户登录入口</h4>
            </div>
            <div class="modal-body">
<%--                登录表单--%>
                <form id="login_form" class="form-horizontal" role="form">
                    <div class="form-group has-feedback">
                        <label for="firstname" class="col-md-2 control-label">用户名</label>
                        <div class="col-md-8">
                            <input name="username" type="text" class="form-control" id="firstname" placeholder="请输入用户名">
                            <span class="form-control-feedback glyphicon glyphicon-user"></span>
                            <label class="text-danger" id="username_label"></label>
                         </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label for="lastname" class="col-md-2 control-label">密码</label>
                        <div class="col-md-8">
                            <input name="password" type="password" class="form-control" id="lastname" placeholder="请输入密码">
                            <span class="form-control-feedback glyphicon glyphicon-lock"></span>
                            <label class="text-danger" id="password_label"></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">请记住我
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
<%--                            修改成一个普通,通过单击事件进行返送--%>
                            <button type="button" onclick="login()" class="btn btn-default">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    //定义一个login函数
    function login(){
        $("#username_label").text("");
        $("#password_label").text("");
        //jquery代码
        //1. 表单序列化
        //key1=value1&key2=value2
        //key一定是文本框的name属性的值
        //value一定是文本框中输入的数据
        let form_data = $("#login_form").serialize();
        //username=fdfd&password=fdfdfdfdfdf

        //用ajax技术发送get请求
        //前端发送数据到后端,前端的数据的格式可以是key-value键值对格式
        $.post('/boot/user',form_data,function(result){
            //此处的data就是后端返回过来的json数据
            //后端 - @ResponseBody把方法的返回结果转成json字符串
            //json字符串被此处的data接受之前,把这个json字符串转成了js中的对象 - json对象
            //json对象.key来获取json的值
            //console.log(result.msg)
            //console.log(result);

            //js
            if(result.code==404){
                // let v = document.getElementById("username_label");//js对象
                // v.innerText = "ss"

                $("#username_label").text(result.msg);//jquery语法 - jquery对象 - jquery的方法
            }else if(result.code==500){
                $("#password_label").text(result.msg);
            }else{
                window.location="http://www.bing.com";
            }
        })
    }
</script>