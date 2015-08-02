package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.GetOrderFactory;

public class AcceptOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String contact=req.getParameter("contact");
		String comment=req.getParameter("comment");
		GetOrderFactory.getGetOrder().addOrdAndRec(id, username, contact, comment);
		GetOrderFactory.getGetOrder().changeOrderRecStatus(id);
		out.print("true");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doGet(req, resp);
	}

}
