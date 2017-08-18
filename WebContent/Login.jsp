    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <!DOCTYPE HTML>
        <html>
        <head>
        <title>枫林晚</title>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">

        <!-- Custom Theme files -->
        <link href="css/loginstyle.css" rel="stylesheet" type="text/css" media="all"/>
        <!-- Custom Theme files -->
        <!--Google Fonts-->
        <link
        href='http://fonts.googleapis.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400'
        rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
        type='text/css'>
        <!--Google Fonts-->
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <script>
        //String message=(String)session.getAttribute("erString");
        var msg = '${sessionScope.erString}';
        if(msg!=''){
        alert(msg);
        }
        var err = '${sessionScope.err}';
        if(err!=''){
        alert(err);
        }
        </script>
        <!--login form start here-->
        <h1>枫林晚</h1>
        <div class="login">
        <div class="rib"> </div>
        <form action="LoginServlet" method="post">
        <input type="text" value="手机号码" name="user_name" onfocus="this.value = '';" onblur="if (this.value == '')
        {this.value = '手机号码';}">
        <input type="password" value="一二三四五六" name="password" onfocus="this.value = '';" onblur="if (this.value == '')
        {this.value = '一二三四五六';}">
        <input type="submit" value="登录" >
        </form>
        <div class="down">
        <a id="fpw" href="FindPwd.jsp" title="找回密码">忘记密码</a>
        <span>还没有账号?</span>
        <a id="ral " href="Register.jsp">立即注册</a>
        </div>
        </div>
        <div id="foot">
        copyright ©2017/7/31<br>
        @fenglinwan
        </div>
        <!--login form end here-->
        </body>
        </html>