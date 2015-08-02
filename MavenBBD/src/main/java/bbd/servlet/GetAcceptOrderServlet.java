package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bbd.factory.GetOrderFactory;
import bbd.vo.AcceptOrder;

public class GetAcceptOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String recname=req.getParameter("recname");
		System.out.println("接受到了："+recname);
		ArrayList<AcceptOrder> list=new ArrayList<AcceptOrder>();
	    list=GetOrderFactory.getGetOrder().getAcceptOrderByName(recname);
	    Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				this.doPost(req, resp);
	}
}
