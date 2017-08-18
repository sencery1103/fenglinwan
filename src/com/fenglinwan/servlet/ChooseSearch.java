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
import com.fenglinwan.service.HotelService;

@WebServlet("/ChooseSearch")
public class ChooseSearch extends HttpServlet {

	/**
	 * 这是使用ajax更新对应城市日期酒店信息的servlet
	 */
	private static final long serialVersionUID = 1L;
	
	public ChooseSearch() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*req.setCharacterEncoding("utf-8");
		String city=req.getParameter("city");
		String date=req.getParameter("date");
		List<Hotel> select = new Link().Select(city, date);
		req.setAttribute("emp", select);
		req.getRequestDispatcher("SearchPage.jsp").forward(req, resp);*/
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html"); 
		resp.setCharacterEncoding("UTF-8");
		String city=req.getParameter("city");
		String date=req.getParameter("date");
		List<Hotel> select = new HotelService().Select(city, date);
		Iterator it=select.iterator();
		PrintWriter out = resp.getWriter();
		while(it.hasNext()){
			Hotel ho=(Hotel)it.next();
			out.println("<script type=\"text/javascript\" src=\"js/SearchPagejs.js\"></script>");
			out.println("<style>.resultbox{ border:solid 1px #858585; width:1000px;height:200px; margin:15px auto}\r\n" + 
					".imgbox{ border:solid 1px #858585; width:180px; height:180px; margin-top:10px; margin-left:10px;; margin-right:30px; float:left;}\r\n" + 
					".textbox{ margin-top:10px; width:550px; float:left; height:180px;}\r\n" + 
					".textbox h1{ font-size:20px;color:#2B66F0; margin-top:0px;}\r\n" + 
					".textbox h2{ font-size:14px;}\r\n" + 
					".textbox h3{ font-size:14px; margin-top:115px;}\r\n" + 
					".pricebox{ float:right;width:100px; margin-top:20px;}\r\n" + 
					".pricebox label{ font-size:18px; color:#D74646;}\r\n" + 
					".pricebox button{ border-radius: 5px;background:#39f; color:#FFF; width:80px; height:30px; border:0; font-size:16px; cursor:pointer; margin-top:105px;}</style>");
		    out.println("<form action=\"Hotelinfo\" method=\"post\">");
			out.println("<div class=\"resultbox\">\r\n" + 
		    		"    	<div class=\"imgbox\">\r\n" + 
		    		"        <img src=\"");
		    out.println(ho.getImgPath());
		    out.println("\" width=\"180px;\" height=\"180px;\">\r\n" + 
		    		"        </div>\r\n" + 
		    		"        <div class=\"textbox\">\r\n" + 
		    		"        	<h1 class=\"h1\">");
		    out.println(ho.getName());
		    out.println("</h1>\r\n" + 
		    		"            <h2 class=\"h2\">");
		    out.println(ho.getLocal());
		    out.println("</h2>\r\n" + 
		    		"            <h3 class=\"h3\">联系电话：");
		    out.println(ho.getPhone());
		    out.println("</h3>\r\n" + 
		    		"        </div>\r\n" + 
		    		"        <div class=\"pricebox\">\r\n" + 
		    		"        <label>￥");
		    out.println(ho.getLessmoney());
		    out.println("起</label>\r\n" + 
		    		"        <button type=\"submit\" onclick=\"getdate(this)\" >查看详情</button>\r\n" + 
		    		"        </div>\r\n" + 
		    		"        <input type=\"hidden\" name=\"hotelid\" value=");
		    out.println(ho.getID());
		    out.println(" >\r\n" + 
		    		"        <input type=\"hidden\" name=\"date\" class=\"choosedate\">\r\n" + 
		    		"    </div>\r\n" + 
		    		"    </form>");
		}
		out.close();
	}
}
