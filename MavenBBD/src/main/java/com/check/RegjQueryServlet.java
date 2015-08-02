package com.check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.CheckUserFactory;
import bbd.vo.User;

public class RegjQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//前端jQuery注册验证
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out = resp.getWriter();
	String username=req.getParameter("username");
	System.out.println(username);
	User user=new User();
	user.setName(username);
	try {
		if(CheckUserFactory.getCheckUser().CheckUser(user.getName())){
			System.out.println("ajax验证中，检测到该用户已经存在！");
			out.print("true");
		}
		else{
			out.print("false");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doPost(req, resp);
	}
}
