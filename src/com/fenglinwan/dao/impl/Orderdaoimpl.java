package com.fenglinwan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenglinwan.dao.Orderdao;
import com.fenglinwan.entity.Order;
import com.fenglinwan.uitl.DButil;

public class Orderdaoimpl implements Orderdao{
	Connection conn=DButil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
    //查询这个人的所有订单
	@Override
	public List<Order> SelectAll(String id) {
		// TODO Auto-generated method stub
		String sql="select * from ORD where user_id=?";
		List <Order> list=new ArrayList<Order>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Order or=new Order();
				or.setOrderid(rs.getString(1));
				or.setUsername(rs.getString(2));
				or.setUserid(rs.getString(3));
				or.setUsersex(rs.getString(4));
				or.setUesrphone(rs.getString(5));
				or.setHotid(rs.getString(6));
				or.setHotname(rs.getString(7));
				or.setRoomname(rs.getString(8));
				or.setRoomid(rs.getString(9));
				or.setMoney(rs.getString(10));
				or.setRoomtype(rs.getString(11));
				or.setOrderdate(rs.getString(12));
				or.setOrderroomdate(rs.getString(13));
				list.add(or);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DButil.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	@Override
	public int ie(String sql, Object... params) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeAll(rs, pstmt, conn);
		}
		
		return result;
	}

	@Override
	public List<Order> Selecthotel(String hotelid) {
		// TODO Auto-generated method stub
		String sql="select * from ORD where hot_id=?";
		List <Order> list=new ArrayList<Order>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, hotelid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Order or=new Order();
				or.setOrderid(rs.getString(1));
				or.setUsername(rs.getString(2));
				or.setUserid(rs.getString(3));
				or.setUsersex(rs.getString(4));
				or.setUesrphone(rs.getString(5));
				or.setHotid(rs.getString(6));
				or.setHotname(rs.getString(7));
				or.setRoomname(rs.getString(8));
				or.setRoomid(rs.getString(9));
				or.setMoney(rs.getString(10));
				or.setRoomtype(rs.getString(11));
				or.setOrderdate(rs.getString(12));
				or.setOrderroomdate(rs.getString(13));
				list.add(or);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DButil.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<Order> SelectRoom(String hotelid, String roomid) {
		// TODO Auto-generated method stub
		String sql="select * from ORD where hot_id=? AND roomid=?";
		List <Order> list=new ArrayList<Order>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, hotelid);
			pstmt.setObject(2, roomid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Order or=new Order();
				or.setOrderid(rs.getString(1));
				or.setUsername(rs.getString(2));
				or.setUserid(rs.getString(3));
				or.setUsersex(rs.getString(4));
				or.setUesrphone(rs.getString(5));
				or.setHotid(rs.getString(6));
				or.setHotname(rs.getString(7));
				or.setRoomname(rs.getString(8));
				or.setRoomid(rs.getString(9));
				or.setMoney(rs.getString(10));
				or.setRoomtype(rs.getString(11));
				or.setOrderdate(rs.getString(12));
				or.setOrderroomdate(rs.getString(13));
				list.add(or);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DButil.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	
}
