package com.fenglinwan.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.dao.impl.Base64;
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
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();

    }
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		String user_name=request.getParameter("user_name");
		String user_phone=request.getParameter("user_phone");
		String user_id=request.getParameter("user_id");
		String pwd=request.getParameter("password");
		String sex=request.getParameter("sex");
		String pwd2=request.getParameter("re_password");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		if(user_name!=null && user_phone!=null && user_id!=null && pwd!=null && sex!=null && pwd2!=null && question!=null && answer!=null) {
			new UserService().Register(user_name, user_phone, user_id, pwd2, answer, question, sex, request, response);
		}else {
			 String smessage="信息不全，注册失败，重新注册";
	         request.getSession().setAttribute("message",smessage);
	         response.sendRedirect("Register.jsp");
		}
	}
}
