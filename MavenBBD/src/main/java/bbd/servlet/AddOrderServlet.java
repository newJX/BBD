package bbd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.AddingOrderFactory;

public class AddOrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String CurrentUserName=req.getParameter("_username");
		String addr=req.getParameter("_addr");
		String title=req.getParameter("_title");
		String content=req.getParameter("_content");
		String pay=req.getParameter("_pay");
		String validtime=req.getParameter("_validtime");
		System.out.println("CurrentUserName:"+CurrentUserName+"\naddr:"+addr+"\ntitle:"+title
		+"\ncontent:"+content+"\npay:"+pay+"\nvalidtime:"+validtime);
		try {
			if(AddingOrderFactory.getAddingOrder().AddOrder(CurrentUserName, addr, title, content, pay, validtime)){
				req.setAttribute("addr", addr);
				req.setAttribute("title", title);
				req.setAttribute("content", content);
				req.setAttribute("pay", pay);
				req.setAttribute("validtime", validtime);
				RequestDispatcher rd=req.getRequestDispatcher("Order_Success");
				rd.forward(req,resp);
			}else{
				System.out.println("ÃÌº”order ß∞‹£°");
				resp.setHeader("refresh", "0;url=Order");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
;	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
