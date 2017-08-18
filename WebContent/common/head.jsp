    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page import="javax.servlet.http.*" %>
        <%@ page import="com.fenglinwan.dao.impl.*" %>
            <%
	String a="hello";
	if(request.getSession().getAttribute("name")!=null){
		Object str=request.getSession().getAttribute("name");
		a=String.valueOf(str);
	}
%>
        <span id="shishi" style="display:none"><%=a%></span>
        <div id="header">
        <form method="post" action="Search" name="form1">
        <div class="lefthead">
        <ul>
        <li><img src="image/logo.png"></li>
        <li><a href="index.jsp">首页</a></li>
        <li><a href="javascript:document:form1.submit();">酒店预定</a></li>
        <li><a href="MyInfo">我的信息</a></li>
        </ul>
        </div>
        </form>
        <div id="righthead">
        <ul>
        <li><a href="Login.jsp">登录</a></li>
        <li><a href="Register.jsp">注册</a></li>
        </ul>
        </div>
        <div id="rightheadtwo">
        <span id="butt">会员：<%=a %>
        &nbsp;您好！</span>
        </div>
        </div>
        <div id="secondmenu">
        <form method="post" action="exit" name="form2">
        <a class="exit" href="javascript:document:form2.submit();">退出</a>
        </form>
        </div>