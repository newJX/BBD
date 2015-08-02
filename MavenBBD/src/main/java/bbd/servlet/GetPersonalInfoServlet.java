package bbd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.factory.PersonalInfoFactory;
import bbd.vo.Info;

import com.google.gson.Gson;

public class GetPersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			String username=req.getParameter("username");
			Info info;
			info=PersonalInfoFactory.getPersonalInfo().GetInfo(username);
			Gson gson=new Gson();
			String json=gson.toJson(info);
			System.out.println("json"+json);
			out.print(json);
        }
        
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        	throws ServletException, IOException {
        	this.doGet(req, resp);
        }
}
