package com.fenglinwan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {

	/**
	 * 退出，清除session
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession   httpsession   =   req.getSession(); 
		httpsession.invalidate(); 
		resp.sendRedirect("index.jsp");
	}
}
