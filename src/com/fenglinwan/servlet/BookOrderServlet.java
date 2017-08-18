package com.fenglinwan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.entity.Comment;
import com.fenglinwan.entity.Order;
import com.fenglinwan.service.CommentService;

/**
 * Servlet implementation class BookOrderServlet
 * 这是订单页面的servlet
 */
@WebServlet("/BookOrderServlet")
public class BookOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookOrderServlet() {
        super();
    }
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//	if (request.getSession().getAttribute("phone")!=null && request.getSession().getAttribute("id")!=null) {
//		//执行预定房间操作	
//		String roomPath=request.getParameter("");
//	    System.out.println(roomPath);
//		
//		String roomId=request.getParameter("roomId");
//		System.out.println(roomId);
//		
//		String roomName=request.getParameter("roomName");
//		System.out.println(roomName);
//		
//		String money=request.getParameter("money");
//		System.out.println(money);
//		
//		
//		response.sendRedirect("Roominfo.jsp");
//		
//		
//	}
//	else
//	{
//		String err="请登录后操作！";
//		request.getSession().setAttribute("err", err);
//		response.sendRedirect("Login.jsp");
//	}
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if (request.getSession().getAttribute("phone")!=null && request.getSession().getAttribute("id")!=null) {
		//执行预定房间操作
	
	    request.setCharacterEncoding("UTF-8");
	    String roomName=request.getParameter("roomName");
	    request.getSession().setAttribute("roomName", roomName);	    
	    request.getSession().setAttribute("roomId", request.getParameter("roomId"));
	    
	    String money=request.getParameter("money");
	    request.getSession().setAttribute("money", money);
	    
	    String path=request.getParameter("roomPath");
	    request.getSession().setAttribute("roomPath", path);
	    
	    String type=request.getParameter("roomType");
	    request.getSession().setAttribute("roomType",type);
	    String orderdate = request.getParameter("date");
		request.getSession().setAttribute("choosedate", orderdate);
		String hotelId = (String) request.getSession().getAttribute("hotelId");
		List<Comment>listordercomment=new CommentService().selectroom(hotelId,request.getParameter("roomId"));
		
		request.getSession().setAttribute("listordercomment", listordercomment);
		response.sendRedirect("Roominfo.jsp");
		
		
		
	}
	else
	{
		String err="请登录后操作！";
		request.getSession().setAttribute("err", err);
		response.sendRedirect("Login.jsp");
	}
	}

}
