package com.fenglinwan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.service.CommentService;

@WebServlet("/setcomment")
public class SetComment extends HttpServlet {

	/**
	 * 提交评论
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html"); 
		resp.setCharacterEncoding("UTF-8");
		String comment=req.getParameter("comment");
		String date=req.getParameter("date");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		System.out.println(name+id+comment+date);
		new CommentService().insert(id, name, comment, date);
		PrintWriter out = resp.getWriter();
		out.println(" <div class=\"inbox_three_left\">");
		out.println("<label >我的评价：</label>\r\n" + 
				"		        	<br>");
		out.println("<button onclick=\"setComment(this)\" class=\"setcomment\" style=\"display:none\">提交</button>");
		out.println("</div>\r\n" + 
				"            	<textarea cols=\"25\" rows=\"3\" class=\"pinglun\" readonly=\"readonly\" style=\"width:300px;height:83px;margin-top:6px;resize: none;\">");
		out.println(comment);
		out.println("</textarea>");
		out.println("<input type=\"hidden\" class=\"getOrderid\" value=");
		out.println(id);
		out.println("> \r\n" + 
				"            	<input type=\"hidden\" class=\"getUsername\" value=");
		out.println(name);
		out.println(" ></div>");
	}
}
