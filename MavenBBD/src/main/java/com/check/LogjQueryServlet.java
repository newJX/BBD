package com.check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.CheckUserFactory;
import bbd.vo.User;

public class LogjQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//ǰ��jQuery��¼��֤	
	
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String username=req.getParameter("username");
		System.out.println("logj�м�⵽�û���Ϊ��"+username);
		String password=req.getParameter("pass1");
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		try {
			if(!CheckUserFactory.getCheckUser().CheckUser(user.getName())){
					System.out.println("ajax��֤�У���⵽�û������ڣ�");
					out.print("false");
			}
			else if(!CheckUserFactory.getCheckUser().CheckUser(user)){
					System.out.println("ajax��֤�У���⵽�û��������");
					out.print("false");
			}
			else{
					out.print("true");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	} 
}

