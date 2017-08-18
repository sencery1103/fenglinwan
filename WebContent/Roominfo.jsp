    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page import="com.fenglinwan.entity.*" %>
        <%@ page import="com.fenglinwan.service.*" %>
        <%@ page import="java.util.*" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <title>枫林晚</title>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/Roominfocss.css">
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <div id="top">
        <div id="daohang">
        <a href="#" onClick="javascript :history.back(-1);">${sessionScope.hotelName} &nbsp;></a>
        <span>&nbsp;${sessionScope.roomId} 房间</span>
        </div>
        <div id="leftimg">
        <img src="${sessionScope.roomPath }" width="700px" height="300px">
        </div>
        <form action="SaveOrderServlet" method="post">
        <div id="rightinfo">
        <h1>预定信息</h1>
        <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#ccc SIZE=1>
        <div class="infoleft">
        <span>入住时间：</span>
        <span>入住人：</span>
        <span>房间类型：</span>
        <span>房间号：</span>
        <span>房间费用：</span>
        </div>
        <div class="inforight">
        <div class="itembox">
        <div class="inputbox">
        <span>${sessionScope.choosedate}</span>
        </div>
        </div>
        <div class="infotext">
        <span>${sessionScope.name}</span>
        <span>${sessionScope.roomName}</span>
        <span>${sessionScope.roomId}</span>
        <span>${sessionScope.money}元</span>
        </div>
        </div>
        <div class="infobottom">
        <button>提交订单</button>
        </div>
        </div>
        </form>
        </div>
            <%
	Object o=request.getSession().getAttribute("listordercomment");
	List<Comment>listordercomment=(ArrayList<Comment>)o;
%>
        <div id="evaluate">

        <h1>房间点评 ></h1>
        <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="95%" color=#ccc SIZE=1>
            <%
	for(Comment co:listordercomment){
		String u=co.getUsername();
		char words[] = u.toCharArray(); 
	%>
        <div class="eva">
        <span><%=words[0]%>**:</span>
        <p><%=co.getSubtance() %></p>
        <div class="date"><%=co.getDate() %></div>
        </div>
            <%
		}
    %>
        </div>
        </body>
        </html>