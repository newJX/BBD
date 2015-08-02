package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.GetOrderFactory;
import bbd.vo.ReleaseOrder;

import com.google.gson.Gson;

public class GetReleaseOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		String username=req.getParameter("username");
		ArrayList<ReleaseOrder> list=new ArrayList<ReleaseOrder>();
		list=GetOrderFactory.getGetOrder().getOrderByName(username);
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
