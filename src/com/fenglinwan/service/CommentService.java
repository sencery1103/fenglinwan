package com.fenglinwan.service;

import java.util.ArrayList;
import java.util.List;

import com.fenglinwan.dao.Commentdao;
import com.fenglinwan.dao.Orderdao;
import com.fenglinwan.dao.Roomdao;
import com.fenglinwan.dao.impl.Commentdaoimpl;
import com.fenglinwan.dao.impl.Orderdaoimpl;
import com.fenglinwan.dao.impl.Roomdaoimpl;
import com.fenglinwan.entity.Comment;
import com.fenglinwan.entity.Order;
import com.fenglinwan.entity.Room;

public class CommentService {
	private Commentdao hd = new Commentdaoimpl();
	
	public void insert(String OrderID, String name, String subtance, String date) {
		hd.insert(OrderID, name, subtance, date);
	}
	
	public List<Comment> selectroom(String hotelid,String roomid) {
		//根据酒店ID和房间ID查询到该房间的所有订单
		List<Order>list=new ArrayList<Order>();
		Orderdao or=new Orderdaoimpl();
		list=or.SelectRoom(hotelid, roomid);
		
		//查询所有的评论
		Commentdao co=new Commentdaoimpl();
		List<Comment> listco=new ArrayList<Comment>();
		listco=co.SelectAll();

		List<Order>listordercomment=new ArrayList<Order>();
		List<Comment>commentroom=new ArrayList<Comment>();
		
		for(Order order:list) {
			for(Comment comment:listco) {
				if(order.getOrderid().equals(comment.getOrderId())) {
					order.setCommented(true);
					listordercomment.add(order);
					}
			}
		}
		
		for(Comment comment:listco) {
			for(Order order:listordercomment) {
				if(order.getOrderid().equals(comment.getOrderId()))
					commentroom.add(comment);
			}
		}
		return commentroom;
		
	}
}
