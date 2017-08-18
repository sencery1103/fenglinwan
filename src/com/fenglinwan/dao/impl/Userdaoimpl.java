package com.fenglinwan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fenglinwan.dao.Userdao;
import com.fenglinwan.entity.User;
import com.fenglinwan.uitl.DButil;
public class Userdaoimpl implements Userdao{
	private Connection conn=DButil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;

	@Override
	public void setMessage(String name,String phone,String id,String pwd,String anse,String ques,String sex) {
		// TODO Auto-generated method stub
		 String sql="INSERT INTO USER_MESSAGE VALUES(?,?,?,?,?,?,?)";
		 try {
			 Connection conns=DButil.getConnection();
			 pstmt=conns.prepareStatement(sql);
			 pstmt.setObject(1, name);
			 pstmt.setObject(2, id);
			 pstmt.setObject(3, pwd);
			 pstmt.setObject(4, sex);
			 pstmt.setObject(5, phone);
			 pstmt.setObject(6, ques);
			 pstmt.setObject(7, anse);
			 rs=pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
            DButil.closeAll(rs, pstmt, conn);
        }

	}

	@Override
	public User Check(String phone,String pwd) {
		// TODO Auto-generated method stub
		User use=new User();
		String sql="SELECT * FROM USER_MESSAGE WHERE user_phone=? AND user_pwd=?";
		try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1, phone);
            pstmt.setObject(2, pwd);
            rs=pstmt.executeQuery();
            if(rs.next()) {
	            use.setName(Base64.getFromBase64(rs.getString("user_name")));
	            use.setPhone(Base64.getFromBase64(rs.getString("user_phone")));
	            use.setId(Base64.getFromBase64(rs.getString("user_id")));
	            use.setPwd(Base64.getFromBase64(rs.getString("user_pwd")));
	            use.setAnswer(Base64.getFromBase64(rs.getString("user_anws")));
	            use.setQuestion(Base64.getFromBase64(rs.getString("user_ques")));
	            use.setSex(Base64.getFromBase64(rs.getString("user_sex")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.closeAll(rs, pstmt, conn);
        }
		return use;
	}
	

	@Override
	public Boolean isinfo(String id,String phone) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM user_message u WHERE u.user_id=? OR u.user_phone=?";
		try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1, id);
            pstmt.setObject(2, phone);
            rs=pstmt.executeQuery();
            if(rs.next()) {
            	return true;
            }
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			 DButil.closeAll(rs, pstmt, conn);
		}
		return false;
	}

	@Override
	public String findpwd(String phone) {
		// TODO Auto-generated method stub
		String a=null;
		String sql="SELECT * FROM USER_MESSAGE WHERE user_phone=?";
		try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1, phone);
            rs=pstmt.executeQuery();
            if(rs.next()) {
            	a=Base64.getFromBase64(rs.getString("user_pwd"));
            	return a;
            }else {
            	return a;
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sql;
	}

}
