package com.fenglinwan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.service.OrderService;
import com.fenglinwan.service.RoomService;

/**
 * Servlet implementation class SaveOrderServlet
 */
@WebServlet("/SaveOrderServlet")
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveOrderServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("name");
		String userId = (String) request.getSession().getAttribute("id");
		String usersex = (String) request.getSession().getAttribute("sex");
		String userPhone = (String) request.getSession().getAttribute("phone");
		String hotelId = (String) request.getSession().getAttribute("hotelId");
		String hotelName = (String) request.getSession().getAttribute("hotelName");
		String roomName = (String) request.getSession().getAttribute("roomName");
		String roomId = (String) request.getSession().getAttribute("roomId");
		String roomMoney = (String) request.getSession().getAttribute("money");
		String orderdate = (String) request.getSession().getAttribute("choosedate");
		String roomType = (String) request.getSession().getAttribute("roomType");
		int result = new OrderService().ie(userName, userId, usersex, userPhone, hotelId, hotelName, roomName, roomId,
				roomMoney, roomType, orderdate);

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (result > 0) {
		    out.println("<html>\r\n" + 
		    		"<head>\r\n" + 
		    		"<meta charset=\"utf-8\">\r\n" + 
		    		"<script>\r\n" + 
		    		"function message(){\r\n" + 
		    		"	alert('预定成功!订单号及相关信息随后将发送至您的手机，请注意查收！');\r\n" + 
		    		"	window.location.href=\"index.jsp\";\r\n" + 
		    		"	}\r\n" + 
		    		"</script>\r\n" + 
		    		"</head>\r\n" + 
		    		"\r\n" + 
		    		"<body onLoad=\"message()\">\r\n" + 
		    		"</body>\r\n" + 
		    		"</html>");
			out.flush();
			out.close();
		} else {
		    out.println("<html>\r\n" + 
		    		"<head>\r\n" + 
		    		"<meta charset=\"utf-8\">\r\n" + 
		    		"<script>\r\n" + 
		    		"function message(){\r\n" + 
		    		"	alert('预定失败！');\r\n" + 
		    		"	window.history.back(-1);;\r\n" + 
		    		"	}\r\n" + 
		    		"</script>\r\n" + 
		    		"</head>\r\n" + 
		    		"\r\n" + 
		    		"<body onLoad=\"message()\">\r\n" + 
		    		"</body>\r\n" + 
		    		"</html>");
		    out.flush();
		    out.close();
		}
		

	}

}
