    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page import="com.fenglinwan.entity.*" %>
        <%@ page import="com.fenglinwan.service.*" %>
        <%@ page import="java.util.*" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员信息</title>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/userInfo.css">
        <script type="text/javascript" src="js/ajax.js"></script>
        </head>

        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
        <div id="middle">
        <div id="left">
        <div id="picture">
        <img alt="头像" src="image/logo.png" class="headimstyle">
        </div>
        <div id="info">
        <label>姓名：</label><label>${sessionScope.name}</label><br><br><br>
        <label>电话号码：</label><label>${sessionScope.phone}</label><br><br><br>
        <label>身份证号：</label><label>${sessionScope.id}</label><br><br><br>
        </div>
        <div id="add"><h1>广告位招商</h1></div>
        </div>
            <% 	Object o=request.getSession().getAttribute("orderlist");
   		List <Order> list=(ArrayList<Order>)o;
   		
   		Object p=request.getSession().getAttribute("roomlist");
   		List <Room> listroom=(ArrayList<Room>)p;
    %>
        <div id="right">
            <%
    	for(Order or: list){
    		
    %>
        <div class="inbox" id="top">
        <div class="inbox_one" id="inbox_one">
            <%
            for(Room ro:listroom){
    			
    			if(or.getHotid().equals(ro.getHotelid())&&or.getRoomid().equals(ro.getRoomId())){
    				
            %>
        <img src="<%=ro.getRoomPath()%>" class="imstyle">
            <%
    				}
    			}
                %>
        </div>
        <div class="inbox_two">
        <span class="txt">酒店名称:<%=or.getHotname()%></span>
        <span class="txt">房间编号:<%=or.getRoomid() %></span>
        <span class="txt">房间类型:<%=or.getRoomtype() %></span>
        <span class="txt">入住日期:<%=or.getOrderroomdate() %></span>
        </div>
        <div class="inbox_three">
        <div class="inbox_three_left">
        <label >我的评价：</label>
        <br>
            <% if(or.isCommented()==false){ %>
        <button onclick="setComment(this)" class="setcomment">提交</button>
        </div>
        <textarea cols="25" rows="3" class="pinglun" style="width:300px;height:83px;margin-top:6px;resize:
        none;"></textarea>
        <input type="hidden" class="getOrderid" value=<%=or.getOrderid()%>>
        <input type="hidden" class="getUsername" value=<%=or.getUsername()%>>
            <%}else{ %>
        <button onclick="setComment(this)" class="setcomment" style="display:none">提交</button>
        </div>
        <textarea cols="25" rows="3" class="pinglun" readonly="readonly"
        style="width:300px;height:83px;margin-top:6px;resize: none;"><%=or.getComment() %></textarea>
        <input type="hidden" class="getOrderid" value=<%=or.getOrderid()%>>
        <input type="hidden" class="getUsername" value=<%=or.getUsername()%>>
            <%} %>
        </div>

        </div>
            <%
    		}
        %>
        </div>
        </body>
        </html>