<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已发布任务</title>
<link href="css/menu.css" rel="stylesheet">
<link href="css/general.css" rel="stylesheet">
<link href="css/release.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/release_order.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
</head>
<body>

<div id="banner">
<div id="status">
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
			pageContext.setAttribute("username", c[i].getName());
			out.print("<a href='Index'>"+c[i].getName()+"</a>");
		}	
	  }  
	}
%>
<a href="Order">发布任务</a>
<a href='LogOutServlet'>退出</a>
</div>
</div>

<div class="container">
  <div class="row">
  <ul class="nav nav-list">
  <li class="nav-header"><B>账号管理</B></li>
   <li><a href="Personal_Info">个人资料</a></li>
   <li><a href="Change_Pass">修改密码</a></li>
  <li class="nav-header"><B>任务管理</B></li>
   <li class="active"><a href=javascript:void(0)>已发布任务</a></li>
   <li><a href="Accept_Assign">已接受任务</a></li>
  </ul>
  </div>
</div>

<input type="hidden" id="username" value=<%=pageContext.getAttribute("username")%>>

<div id="release"></div>

</body>
</html>