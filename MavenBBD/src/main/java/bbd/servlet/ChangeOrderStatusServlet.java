package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.GetOrderFactory;

public class ChangeOrderStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		boolean flag=false;
		flag=GetOrderFactory.getGetOrder().changeOrderStatus(id);
		if(flag==true){
			out.print("true");
		}else if(flag==false){
			out.print("false");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				this.doPost(req, resp);
	}
}
