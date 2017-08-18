package com.fenglinwan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.entity.Hotel;
import com.fenglinwan.entity.Room;
import com.fenglinwan.service.HotelService;
import com.fenglinwan.service.RoomService;

@WebServlet("/ChooseRoom")
public class ChooseRoom extends HttpServlet {

	/**
	 * 这是使用ajax更新对应日期房间信息的servlet
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html"); 
		resp.setCharacterEncoding("UTF-8");
		String hotelid=(String)req.getSession().getAttribute("hotelId");
		String date=req.getParameter("date");
		List<Room> select=new RoomService().getRoom(hotelid,date);
		Iterator it=select.iterator();
		PrintWriter out = resp.getWriter();
		int i=0;
		while(it.hasNext()){
			Room ro=(Room)it.next();
			out.println("<script type=\"text/javascript\">\r\n" + 
					"	function getdate(obj){\r\n" + 
					"		var j=0;\r\n" + 
					"		var o=document.getElementsByClassName('shishi');\r\n" + 
					"		for(var i=0;i<o.length;i++){\r\n" + 
					"			if(obj==o[i]){\r\n" + 
					"				j=i;\r\n" + 
					"			}\r\n" + 
					"		}\r\n" + 
					"		var a=document.getElementsByClassName('choosedate').item(j);\r\n" + 
					"		var getdate=document.getElementById('datepicker').value;\r\n" + 
					"		a.value=getdate;\r\n" + 
					"	}\r\n" + 
					"	</script>");
			out.println("<style>\r\n" + 
					".resultbox{ border:solid 1px #858585; width:450px;height:200px; float:left; margin-left:20px;margin-top: 10px;}\r\n" + 
					".imgbox{ border:solid 1px #858585; width:180px; height:180px; margin-top:10px; margin-left:10px;; margin-right:30px; float:left;}\r\n" + 
					".textbox{ margin-top:10px; width:80px; float:left; height:180px;}\r\n" + 
					".textbox h1{ font-size:20px;color:#2B66F0; margin-top:0px; width:100px;}\r\n" + 
					".textbox h2{ font-size:14px;}\r\n" + 
					".textbox h3{ font-size:14px; margin-top:115px;}\r\n" + 
					".pricebox{ float:right;width:100px; margin-top:20px;}\r\n" + 
					".pricebox label{ font-size:18px; color:#D74646;}\r\n" + 
					".boxxx{ width:1068px; background-color:#EFEFEF; margin:10px auto; height:80px;}\r\n" + 
					".boxxx span{ font-size:17px; font-weight:bold; line-height:30px; margin-left:20px;}\r\n" + 
					".pricebox button{border-radius: 3px; background:#39f; color:#FFF; width:80px; height:30px; border:0; font-size:16px; cursor:pointer; margin-top:105px;}\r\n" + 
					".pricebox button:hover{background:#007bf7}\r\n" + 
					"</style>");
			out.println("<form action=\"BookOrderServlet\" method=\"post\" id=\"");
			out.println(i);
			out.println("\">\r\n" + 
					"	<div class=\"resultbox\">\r\n" + 
					"    	<div class=\"imgbox\">\r\n" + 
					"        <img src=\"");
			out.println(ro.getRoomPath());
			out.println("\" width=\"180px;\" height=\"180px;\">\r\n" + 
					"        </div>\r\n" + 
					"            <div class=\"textbox\">\r\n" + 
					"        	<h1 class=\"h1\" >");
			out.println(ro.getRoomName());
			out.println("</h1>\r\n" + 
					"            <h2 class=\"h2\" >");
			out.println(ro.getRoomId());
			out.println("</h2>\r\n" + 
					"            <h3 class=\"h3\">楼层：5楼 </h3>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"pricebox\">\r\n" + 
					"        <label>￥");
			out.println(ro.getMoney());
			out.println("</label>");
			if(ro.getRoomed()==false){
				out.println("<button type=\"submit\" onclick=\"getdate(this)\" class=\"shishi\">预定</button>");
			}
			 if(ro.getRoomed()==true){ 
				out.println(" <button type=\"submit\" disabled=\"disabled\" style=\"background:#909090;\" class=\"shishi\">已被预定</button>");
			 }
			out.println("<input type=\"hidden\" name=\"roomName\" value=");
			out.println(ro.getRoomName());
			out.println(">\r\n" + 
					"                <input type=\"hidden\" name=\"roomId\" value=");
			out.println(ro.getRoomId());
			out.println(">\r\n" + 
					"                <input type=\"hidden\" name=\"money\" value=");
			out.println(ro.getMoney());
			out.println(">\r\n" + 
					"                <input type=\"hidden\" name=\"roomPath\" value=");
			out.println(ro.getRoomPath());
			out.println(">\r\n" + 
					"                <input type=\"hidden\" name=\"roomType\" value=");
			out.println(ro.getRoomtype());
			out.println(">\r\n" + 
					"                <input type=\"hidden\" name=\"date\" class=\"choosedate\">\r\n" + 
					"        </div>\r\n" + 
					"    </div>\r\n" + 
					"     </form>");
		}
		out.close();
	}
}
