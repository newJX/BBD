<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料</title>
<link href="css/menu.css" rel="stylesheet">
<link href="css/ordersuccess.css" rel="stylesheet">
<link href="css/general.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
</head>
<body>
<div id="banner">
<div id="status">
<a href="Index" id="bbd"  style="margin-right:520px;font-family:HVD Bodedo"><B>BBD.COM</B></a>
<%--这里需要加用户是否已经登录判断，防止直接通过审查代码调用logoutservlet--%>
<%
   Cookie c[]=request.getCookies();
   if((session.isNew()&&c==null)||(!session.isNew()&&c.length==1)) 
	{
	   response.sendRedirect("Index"); 
	}
   else if((session.isNew()&&c.length==1)||(!session.isNew()&&c.length>1)){
		for(int i=0;i<c.length;i++){
			if(!c[i].getName().equals("JSESSIONID")){
				pageContext.setAttribute("username", URLDecoder.decode(c[i].getName(), "UTF-8"));
				out.print("<a href='Index'>"+URLDecoder.decode(c[i].getName(), "UTF-8")+"</a>");
		}	
	  }  
	}
%>
<a href="Personal_Info">个人中心</a>
<a href="Order">发布任务</a>
<a href='LogOutServlet'>退出</a>
</div>
</div>
<div id="status_line"></div>

<div id="display">
<div id="success">任务发布成功！</div>
<div id="addr">地址：<%=request.getAttribute("addr") %></div>
<div id="title">标题：<%=request.getAttribute("title") %></div>
<div id="content">任务内容：<%=request.getAttribute("content") %></div>
<div id="pay">酬劳：<%=request.getAttribute("pay") %>块(RMB)</div>
<div id="validtime">有效时间：<%=request.getAttribute("validtime") %>小时</div>
</div>
<div id="return" style="position:absolute;">
3秒后自动返回到
<a href="Index">首页</a>
<meta http-equiv="refresh" content="3; url=Index">
</div>





</body>
</html>