    <%@page import="com.sun.org.apache.xpath.internal.operations.Lte" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8"
                 pageEncoding="UTF-8" %>
        <%@ page import="java.util.*" %>
        <%@ page import="com.fenglinwan.entity.*" %>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/myjquery.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/SearchPageCss.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/SearchPagejs.js"></script>
        <title>枫林晚</title>
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <div id="search">
        <div class="itembox">
        <span>城市</span>
        <div class="inputbox">
        <select name="city" id="city">
        <option value ="重庆">重庆</option>
        <option value ="北京">北京</option>
        <option value ="四川">四川</option>
        <option value ="深圳">深圳</option>
        </select>
        </div>
        </div>


        <div class="itembox">
        <span>入住日期</span>
        <div class="inputbox">
        <input type="text" id="datepicker" class="dateinput" name="date" readonly="readonly">
        </div>
        </div>

        <div class="itembox">
        <button type="submit" class="searchButton" onclick="qiehuan()">搜索</button>
        </div>
        </div>
            <%
	List<Hotel> select=(ArrayList)request.getAttribute("emp");
	Iterator it=select.iterator();
%>
        <div id="shouResult">

            <%
		while(it.hasNext()){
			Hotel ho=(Hotel)it.next();
	%>
        <form action="Hotelinfo" method="post">
        <div class="resultbox">
        <div class="imgbox">
        <img src="<%= ho.getImgPath() %>" width="180px;" height="180px;">
        </div>
        <div class="textbox">
        <h1 class="h1"><%= ho.getName() %></h1>
        <h2 class="h2"><%= ho.getLocal() %></h2>
        <h3 class="h3">联系电话：<%= ho.getPhone() %></h3>
        </div>
        <div class="pricebox">
        <label>￥<%=ho.getLessmoney() %>起</label>
        <button type="submit" onclick="getdate(this)" class="shishi">查看详情</button>
        </div>
        <input type="hidden" name="hotelid" value=<%=ho.getID() %>
        >
        <input type="hidden" name="date" class="choosedate">
        </div>
        </form>
            <%
		}
	%>
        </div>

        </body>
        </html>