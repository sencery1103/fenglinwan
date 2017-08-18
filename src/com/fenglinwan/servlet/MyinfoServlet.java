package com.fenglinwan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.entity.Order;
import com.fenglinwan.entity.Room;
import com.fenglinwan.service.OrderService;
import com.fenglinwan.service.RoomService;


/*
 * 我的信息
 * */
@WebServlet("/MyInfo")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyinfoServlet() {
        super();

    }

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //查看我的信息
	String id=(String) request.getSession().getAttribute("id");
	if (request.getSession().getAttribute("phone")!=null && id!=null) {
		
		List <Order> list=new OrderService().Select(id);
		List <Room>  listroom=new RoomService().SelectAll();
		request.getSession().setAttribute("orderlist", list);
		request.getSession().setAttribute("roomlist", listroom);
		response.sendRedirect("userInfo2.jsp");
		
	}
	else
	{
		String err="请登录后操作！";
		request.getSession().setAttribute("err", err);
		response.sendRedirect("Login.jsp");
	}

}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

