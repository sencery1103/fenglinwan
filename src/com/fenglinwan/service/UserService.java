package com.fenglinwan.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.dao.Userdao;
import com.fenglinwan.dao.impl.Base64;
import com.fenglinwan.dao.impl.Userdaoimpl;
import com.fenglinwan.entity.User;

public class UserService {
	private Userdao ud=new Userdaoimpl();
	
	public void Register(String name,String phone,String id,String pwd,String anse,String ques,String sex,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String base64_user_name=Base64.getBase64(name);
		String base64_user_phone=Base64.getBase64(phone);
		String base64_user_id=Base64.getBase64(id);
		String base64_password=Base64.getBase64(pwd);
		String base64_sex=Base64.getBase64(sex);
		String base64_ques=Base64.getBase64(ques);
		String base64_anws=Base64.getBase64(anse);
		
		
		
		
		//检查是否有该帐号
		if(ud.isinfo(base64_user_id, base64_user_phone)==true) {
			String smessage="注册失败，已存在该用户";
			request.getSession().setAttribute("message",smessage);
			response.sendRedirect("Register.jsp");
		}else {
			ud.setMessage(base64_user_name, base64_user_phone, base64_user_id, base64_password, base64_anws, base64_ques, base64_sex);
			String smessage="注册成功，请登录！";
	        request.getSession().setAttribute("message",smessage);
	        response.sendRedirect("Login.jsp");
		}
	}
	
	public User login(String user_phone,String user_pwd) {
		String phone=Base64.getBase64(user_phone);
		String pwd=Base64.getBase64(user_pwd);
		User use=ud.Check(phone, pwd);
		return use;
	}
	
	public String Findpwd(String phone) {
		String a=ud.findpwd(Base64.getBase64(phone));
		if(a!=null) {
			System.out.println(a);
			String mess="您的密码已通过短信发送至您的手机，请注意查收！";
			return mess;
		}else {
			a="查询条件不足或用户不存在！";
		}
		return a;
	}
}
