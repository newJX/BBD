package bbd.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.AddingUserFactory;
import bbd.factory.CheckUserFactory;
import bbd.factory.PersonalInfoFactory;
import bbd.vo.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String User=req.getParameter("username").replaceAll("[\\s*\t\n\r]", "");
		String Password1=req.getParameter("pass1").replaceAll("[\\s*\t\n\r]", "");
		String Password2=req.getParameter("pass2").replaceAll("[\\s*\t\n\r]", "");
       System.out.println(User);
		//用户名为空
		if(User==null||User.equals("")){
			resp.setHeader("refresh", "0;url=Register");
        }
		//密码1为空
        else if(Password1==null||Password1.equals("")){
        	resp.setHeader("refresh", "0;url=Register");
        }
		//密码2为空
        else if(Password2==null||Password2.equals("")){
        	resp.setHeader("refresh", "0;url=Register");
        }
		//两次密码输入不一致
        else if(!Password1.equals(Password2)){
        	resp.setHeader("refresh", "0;url=Register");
        }
		//格式验证通过
        else {
        	User user=new User();
    		user.setName(User);
    		user.setPassword(Password1);
    		try {
    			if(!CheckUserFactory.getCheckUser().CheckUser(user.getName())){
    				System.out.println("RegisterServlet检测到该用户不存在");
    				AddingUserFactory.getAddingUser().AddUser(user);
    				PersonalInfoFactory.getPersonalInfo().AddInfo(user.getName());
    				Cookie c1=new Cookie(URLEncoder.encode(user.getName(),"UTF-8"),"");
    			    c1.setMaxAge(6000000);
    			    resp.addCookie(c1);
    			    //客户端跳转
    			    resp.setHeader("refresh", "0;url=Index");
    			}
    			else if(CheckUserFactory.getCheckUser().CheckUser(user.getName())){
    				System.out.println("RegisterServlet检测该用户已经存在");
    				resp.setHeader("refresh", "0;url=Register");
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
