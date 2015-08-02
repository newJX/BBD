package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.GetOrderFactory;
import bbd.vo.Order;

import com.google.gson.Gson;

public class GetOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String address=req.getParameter("address");
		String keyword=req.getParameter("keyword");
		System.out.println(address+">>>"+keyword);
		ArrayList<Order> list=new ArrayList<Order>();
		list=GetOrderFactory.getGetOrder().getOrderByKeyword(address, keyword);
		System.out.println("Servlet:"+list.size());
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println("json1"+json);
		out.print(json);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				this.doGet(req, resp);
	}
}
