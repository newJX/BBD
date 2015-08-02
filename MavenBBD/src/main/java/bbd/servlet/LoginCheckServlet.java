package bbd.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.CheckUserFactory;
import bbd.vo.User;

@SuppressWarnings("serial")
public class LoginCheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String User=req.getParameter("username").replaceAll("[\\s*\t\n\r]", "");
		String Password=req.getParameter("pass1").replaceAll("[\\s*\t\n\r]", "");
		System.out.println("logincheck�м�⵽���û���Ϊ��"+User);
		 //�û���Ϊ��
		if(User==null||User.equals("")){
			resp.setHeader("refresh", "0;url=Login");
        }
		//����1Ϊ��
        else if(Password==null||Password.equals("")){
        	resp.setHeader("refresh", "0;url=Login");
        }
		//��֤ͨ��
        else{
        	User user=new User();
    		user.setName(User);
    		user.setPassword(Password);
    		try {
    			if(CheckUserFactory.getCheckUser().CheckUser(user)){
    				Cookie c1=new Cookie(URLEncoder.encode(user.getName(),"UTF-8"),"");
    			    c1.setMaxAge(6000000);
    			    resp.addCookie(c1);
    			    //�ͻ�����ת
    			    resp.setHeader("refresh", "0;url=Index");
    			}else{
    				resp.setHeader("refresh", "0;url=Login");
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
