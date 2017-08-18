package com.fenglinwan.servlet;

import java.io.IOException;
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

@WebServlet("/Hotelinfo")
public class HotelinfoServlet extends HttpServlet {
	/**
	 * 这是显示酒店详细信息的servlet,他会跳转到hotelinfo.jsp
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getSession().setAttribute("choosedate", req.getParameter("date"));
		String hotelid=(String)req.getParameter("hotelid");
		String date=(String)req.getParameter("date");
		List<Hotel>select=new HotelService().Select(hotelid);
		List<Room> selects=new RoomService().getRoom(hotelid,date);
		req.getSession().setAttribute("roomobj", selects);
		Iterator it=select.iterator();
		while(it.hasNext()){
			Hotel ho=(Hotel)it.next();
			req.getSession().setAttribute("hotelobj", ho);
		}
		resp.sendRedirect("Hotelinfo.jsp");
	}
}
