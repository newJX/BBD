package bbd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.CheckUserFactory;
import bbd.factory.UpdatePasswordFactory;
import bbd.vo.User;

public class ChangePasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String CurrentUserName=req.getParameter("username");
		String CurrentPassword=req.getParameter("pass1").replaceAll("[\\s*\t\n\r]", "");
		String NewPassword1=req.getParameter("pass2").replaceAll("[\\s*\t\n\r]", "");
		String NewPassword2=req.getParameter("pass3").replaceAll("[\\s*\t\n\r]", "");
		System.out.println("当前名字："+CurrentUserName);
		//后台验证输入格式
		if(CurrentPassword==null||CurrentPassword.equals("")){
			resp.setHeader("refresh", "0;url=Change_Pass");
		}
		else if(NewPassword1==null||NewPassword1.equals("")){
			resp.setHeader("refresh", "0;url=Change_Pass");
		}
		else if(NewPassword2==null||NewPassword2.equals("")){
			resp.setHeader("refresh", "0;url=Change_Pass");
		}
		
		else if(!NewPassword1.equals(NewPassword2)){
			resp.setHeader("refresh", "0;url=Change_Pass");
		}
		else{
			User user=new User();
			user.setName(CurrentUserName);
			user.setPassword(CurrentPassword);
			try {
				if(CheckUserFactory.getCheckUser().CheckPassword(user)){
					UpdatePasswordFactory.getUpdatePassword().UpdatePassword(user, NewPassword1);
					resp.setHeader("refresh", "0;url=NewPass_Success");
					System.out.println("修改密码成功！");
				}
				else{
					resp.setHeader("refresh", "0;url=Change_Pass");
					System.out.println("修改密码失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
