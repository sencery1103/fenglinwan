package com.fenglinwan.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fenglinwan.dao.Commentdao;
import com.fenglinwan.dao.Orderdao;
import com.fenglinwan.dao.impl.Commentdaoimpl;
import com.fenglinwan.dao.impl.Orderdaoimpl;
import com.fenglinwan.entity.Comment;
import com.fenglinwan.entity.Order;
import com.fenglinwan.entity.Room;

public class OrderService {
	private Orderdao hd = new Orderdaoimpl();
	List<Order> list = new ArrayList<Order>();
	
	//查询这个人的所有订单
	public List<Order> SelectAll(String id) {
		list = hd.SelectAll(id);
		return list;
	}

	public int ie( Object... params) {
		String sql = "INSERT INTO ORD VALUES(seq_order_id.nextval,?,?,?,?,?,?,?,?,?,?,sysdate,?)";
		int i = hd.ie(sql, params);
		return i;
	}
	
	//根据ID查询所有订单 评论还是未评论
	public List<Order> Select(String id) {
		List<Order> listorder = new ArrayList<Order>();
		//[1]根据ID查询这个用户的所有订单
		list=hd.SelectAll(id);
		//[2]查询所有的评论
		Commentdao co=new Commentdaoimpl();
		List<Comment> listco=new ArrayList<Comment>();
		listco=co.SelectAll();

		//[3]根据订单号，如果已存在评论表里，则设置为已评论
		Iterator its=list.iterator();
		while(its.hasNext()) {
			Order or=(Order)its.next();
			Iterator coit=listco.iterator();
			while(coit.hasNext()) {
				Comment comment=(Comment)coit.next();
				if(or.getOrderid().equals(comment.getOrderId())) {
					or.setCommented(true);
					or.setComment(comment.getSubtance());
				}
			}
			listorder.add(or);
		}
		
		return listorder;
	}
}
