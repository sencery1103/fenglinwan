package com.fenglinwan.dao;

import com.fenglinwan.entity.User;

public interface Userdao {
	public User Check(String phone,String pwd);
	
	public void setMessage(String name,String phone,String id,String pwd,String anse,String ques,String sex);
	
	public Boolean isinfo(String id,String phone);
	
	public String findpwd(String phone);
}
