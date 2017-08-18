    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page import="com.fenglinwan.entity.*" %>
        <%@ page import="com.fenglinwan.service.*" %>
        <%@ page import="java.util.*" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/headjs.js"></script>
        <link href="css/headcss.css" rel="stylesheet" type="text/css">
        <title>枫林晚</title>
        <link rel="stylesheet" type="text/css" href="css/hotelInfo.css" >
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>

        <script type="text/javascript">
        function getdate(obj){
        var j=0;
        var o=document.getElementsByClassName('shishi');
        for(var i=0;i<o.length;i++){
        if(obj==o[i]){
        j=i;
        }
        }
        var a=document.getElementsByClassName('choosedate').item(j);
        var getdate=document.getElementById('datepicker').value;
        a.value=getdate;
        }

        $(function() {

        $( "#datepicker" ).datepicker({
        dateFormat:"yy-mm-dd",
        minDate:0,
        maxDate:+2
        });
        $("#datepicker").datepicker( 'setDate' ,$("#getdate").val());
        });
        </script>
        <style>
        body{font-family:Arial, Helvetica, sans-serif,"宋体";background:#edf1fe;}
        </style>
        </head>
        <body onload="qiehuanlogin()">
        <%@ include file="common/head.jsp" %>
            <%
        Object ass=request.getSession().getAttribute("hotelobj");
        Hotel ho=(Hotel)ass;
        request.getSession().setAttribute("hotelName", ho.getName());
        request.getSession().setAttribute("hotelId", ho.getID());
        %>
        <div id="wrap">
        <div id="content">
        <div class="box" id="box1">
        <img src="<%=ho.getRoompath1() %>" width="250px" height="250px">
        </div>
        <div class="box">
        <img src="<%=ho.getRoompath2() %>" width="250px" height="250px">
        </div>
        <div class="box">
        <div class="boxTop"><img src="<%=ho.getRoompath3() %>" width="250px" height="125px"></div>
        <div class="boxBottom"><img src="<%=ho.getRoompath4() %>" width="250px" height="125px"></div>
        </div>

        <div class="box">
        <h1><%=ho.getName() %></h1>
        <p>地址：<%=ho.getLocal() %></p>
        <p>联系方式：<%=ho.getPhone() %></p>
        <h2>￥<%=ho.getLessmoney()%>起</h2>
        </div>
        </div>
        </div>
        <div class="boxxx">
        <span>选择房间 ></span>
        <div class="itembox">
        <span>入住时间：</span>
        <div class="inputbox">
        <input type="text" id="datepicker" class="dateinput" name="date" readonly="readonly"/>
        <input type="hidden" id="getdate" value="<%= request.getSession().getAttribute("choosedate")%>">
        </div>
        <button class="changetime" onclick="qiehuanroom()">确认修改</button>
        </div>
        </div>
        <div id="shouResult">
            <%
		Object b=request.getSession().getAttribute("roomobj");
		List<Room> selects=(ArrayList<Room>)b;
		Iterator its=selects.iterator();
		int i=0;
		while(its.hasNext())
		   {
			Room ro=(Room)its.next();
	%>
        <form action="BookOrderServlet" method="post" id="<%=i%>">
        <div class="resultbox">
        <div class="imgbox">
        <img src="<%=ro.getRoomPath()%>" width="180px;" height="180px;">
        </div>
        <div class="textbox">
        <h1 class="h1" ><%= ro.getRoomName()%></h1>
        <h2 class="h2" ><%=ro.getRoomId()%></h2>
        <h3 class="h3">楼层：5楼 </h3>
        </div>
        <div class="pricebox">
        <label>￥<%=ro.getMoney()%></label>
            <%if(ro.getRoomed()==false){%>
        <button type="submit" onclick="getdate(this)" class="shishi">预定</button>
            <%} %>
            <%if(ro.getRoomed()==true){ %>
        <button type="submit" disabled="disabled" style="background:#909090;" class="shishi">已被预定</button>
            <%} %>
        <input type="hidden" name="roomName" value=<%=ro.getRoomName()%>>
        <input type="hidden" name="roomId" value=<%=ro.getRoomId()%>>
        <input type="hidden" name="money" value=<%=ro.getMoney()%>>
        <input type="hidden" name="roomPath" value=<%=ro.getRoomPath()%>>
        <input type="hidden" name="roomType" value=<%=ro.getRoomtype()%>>
        <input type="hidden" name="date" class="choosedate">
        </div>
        </div>
        </form>
            <%
		}
	%>

        </div>


        </body>
        </html>