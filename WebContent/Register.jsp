    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员注册</title>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <link href="css/Register.css" rel="stylesheet" type="text/css">

        <script type="text/javascript">

        function checkUser(user_name)
        {
        if(user_name=="请填写身份证中的姓名")
        {
        alert("请输入姓名！！！");
        }
        }
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
        function checkpwd(password)
        {
        if(password=="6~16个字符，区分大小写")
        {
        alert("请输入密码！！！");
        }
        else
        if ((/^(\d|[a-z]|[A-Z]){6,16}$/).test(password)===false)
        {
        alert("密码不符合规则！");
        return false;
        }
        }
        function camparepwd(re_password)
        {
        if(re_password=="请再次填写密码")
        {
        alert("请确认密码！！！");
        }
        else
        {
        if(re_password!=register.password.value)
        {
        alert("两次密码不一致，请重新输入！！！");
        }
        }
        }
        </script>
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <h4><%=(session.getAttribute("message") == null) ? "" : session.getAttribute("message") %>
        </h4>
        <form name="register" action="RegisterServlet" method="post">
        <div id="box">
        <label >姓名</label><input id="user_name"class="iput" type="text" name="user_name" value="请填写身份证中的姓名"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} checkUser(this.value);"
        style="color:#999999"><br><br><br>


        <label>手机号码</label><input class="iput" type="text" name="user_phone" value="可作为登录名"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} isPhone(this.value);"
        style="color:#999999"><br><br><br>


        <label>身份证号码</label><input class="iput" type="text" name="user_id" value="请填写身份证号"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} isCardNo(this.value);"
        style="color:#999999"><br><br><br>


        <label>密码</label><input class="iput" type="password" name="password" placeholder="6~16个字符，区分大小写"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} checkpwd(this.value);"
        style="color:#999999"><br><br><br>


        <label>确认密码</label><input class="iput" type="password" name="re_password" placeholder="请再次填写密码"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'} camparepwd(this.value);"
        style="color:#999999"><br><br><br>


        <label>提示问题</label><input class="iput" type="text" name="question"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br><br><br>


        <label>问题答案</label><input class="iput" type="text" name="answer"
        onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
        onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br><br><br>

        <label style="margin-left:-40px">性别</label><label style="margin-left:100px;"><input type="radio" name="sex"
        value="男" checked>男</label>
        <label><input type="radio" name="sex" value="女">女</label><br>
        <button type="submit">注册</button>
        </div>
        </form>
        </body>
        </html>