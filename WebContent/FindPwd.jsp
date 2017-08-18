    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>找回密码</title>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <link href="css/FindPwd.css" rel="stylesheet" type="text/css">
        <script type="text/javascript">
        function isPhone(user_phone)
        {
        //验证手机号是否合法
        // var reg=/^1((3[0-9])|(4[5|7])|(5([0-3]|[5-9]))|(8[0-9]))(^\d{8}$)/;
        var reg=/^1[3|4|5|7|8][0-9]\d{8}$/
        if(reg.test(user_phone) === false)
        {
        alert("手机号码输入不合法，请重新输入");
        return false;
        }
        }
        function isCardNo(user_id)
        {
        // 身份证号码为18位,18位前17位为数字，最后一位是校验位，可能为数字或字符X
        var reg = /^\d{17}(\d|X)$/;
        if(reg.test(user_id) === false)
        {
        alert("身份证输入不合法,请重新输入");
        return false;
        }
        }
        </script>
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <form name="FindPwd" action="FindPwdServlet" method="post">
        <div id="box">
        <label>手机号码:</label><input class="iput" type="text" name="user_phone" value="请填写注册时预留手机号"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} isPhone(this.value);"
        style="color:#999999"><br><br><br>


        <label>身份证号码:</label><input class="iput" type="text" name="user_id" value="请填写注册身份证号"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} isCardNo(this.value);"
        style="color:#999999"><br><br><br>


        <label>提示问题：</label><input class="iput" type="text" name="question" value="请填写注册时预留密保问题"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br><br><br>


        <label>问题答案：</label><input class="iput" type="text" name="answer" value="请填写注册时预留密保问题答案"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br><br><br>

        <button>找回密码</button>
        </div>
        </form>
        </body>
        </html>