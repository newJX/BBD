package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.PersonalInfoFactory;
import bbd.vo.Info;

public class UpdatePersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String username=req.getParameter("username");
		String sex=(req.getParameter("optionsRadiosinline").equals("option1")?"male":"female");
		String birthday=req.getParameter("birthday");
		String addr1=(req.getParameter("addr1")==null?"":req.getParameter("addr1"));
		String addr2=(req.getParameter("addr2")==null?"":req.getParameter("addr2"));
		String addr3=(req.getParameter("addr3")==null?"":req.getParameter("addr3"));
		String introduction=(req.getParameter("introduction")==null?"":req.getParameter("introduction"));
		Info info=new Info();
		info.setUsername(username);
		info.setSex(sex);
		info.setBirthday(birthday);
		info.setAddr1(addr1);
		info.setAddr2(addr2);
		info.setAddr3(addr3);
		info.setIntroduction(introduction);
		if(PersonalInfoFactory.getPersonalInfo().ChangeInfo(info)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
