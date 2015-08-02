package bbd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie c[]=req.getCookies();
		for(int i=0;i<c.length;i++){
			System.out.print(c[i].getName()+":：："+c[i].getValue()+"\n");
		}
		for(int i=0,len=c.length;i<len;i++) {
            Cookie cookie = new Cookie(c[i].getName(),"");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
		resp.setHeader("refresh", "0;url=Index");
		System.out.println("已经用到logoutservlet");
}
}
