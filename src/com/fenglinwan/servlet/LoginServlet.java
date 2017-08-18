package com.fenglinwan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fenglinwan.dao.Userdao;
import com.fenglinwan.dao.impl.*;
import com.fenglinwan.entity.User;
import com.fenglinwan.service.UserService;

/*
 * 
 * .......................我佛慈悲...................... 
 *                       _oo0oo_ 
 *                      o8888888o 
 *                      88" . "88 
 *                      (| -_- |) 
 *                      0\  =  /0 
 *                    ___/‘---'\___ 
 *                  .' \\|     |// '. 
 *                 / \\|||  :  |||// \ 
 *                / _||||| -卍-|||||- \ 
 *               |   | \\\  -  /// |   | 
 *               | \_|  ''\---/''  |_/ | 
 *               \  .-\__  '-'  ___/-. / 
 *             ___'. .'  /--.--\  `. .'___ 
 *          ."" '<  `.___\_<|>_/___.' >' "". 
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | | 
 *         \  \ `_.   \_ __\ /__ _/   .-` /  / 
 *     =====‘-.____`.___ \_____/___.-`___.-'===== 
 *                       “=---=” 
 *                        
 *.....................佛祖开光 ,永无BUG................... 
 *  
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_phone = request.getParameter("user_name");
		String user_pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60);
		try {
			User user = new UserService().login(user_phone, user_pwd);
			if (user.getName() != null) {
				String name = (String) user.getName();
				String id = (String) user.getId();
				String phone = (String) user.getPhone();
				String sex=(String )user.getSex();
				session.setAttribute("name", name);
				session.setAttribute("id", id);
				session.setAttribute("phone", phone);
				session.setAttribute("sex", sex);
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect("index.jsp");

			} else {
				String meString = "登录失败，请输入正确的账号和密码！！！";
				session.setAttribute("erString", meString);
				response.sendRedirect("Login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
