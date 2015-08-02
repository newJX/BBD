<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料</title>
<link href="css/jQuery UI/jquery-ui.min.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/jQuery UI/jquery-ui.min.js"></script>
<script src="js/jQuery UI/jquery-ui-i18n.js"></script>
<script src="js/info.js"></script>
<link href="css/menu.css" rel="stylesheet">
<link href="css/general.css" rel="stylesheet">
<link href="css/info.css" rel="stylesheet">
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
<a href="Order">发布任务</a>
<a href='LogOutServlet'>退出</a>
</div>
</div>
<div id="status_line"></div>

<div id="menu_div" class="container">
  <div class="row">
  	<ul class="nav nav-list">
  		<li class="nav-header"><B>账号管理</B></li>
   			<li class="active"><a href=javascript:void(0)>个人资料</a></li>
   			<li><a href="Change_Pass">修改密码</a></li>
  		<li class="nav-header"><B>任务管理</B></li>
  			<li><a href="Release_Assign">已发布任务</a></li>
   			<li><a href="Accept_Assign">已接受任务</a></li>
    </ul>
  </div>
</div>

<div id="info_div">
  <form method="post" id="info_form" role="form" class="form-horizontal">
	<div class="form-group">
		<span id="name">用户名：</span>
		<input type="hidden" id="username" name="username" value=<%=pageContext.getAttribute("username") %>>
		<p class="form-control-static"><%=pageContext.getAttribute("username") %></p>
	</div>
	<div class="form-group">
		<span id="sex">性别：</span>
		<label class="checkbox-inline">
    	  	<input type="radio" name="optionsRadiosinline" id="male" value="option1" checked> 男
   		</label>
  		<label class="checkbox-inline">
     		 <input type="radio" name="optionsRadiosinline" id="female" value="option2"> 女
    	</label>
	</div>
	<div class="form-group">
		<span id="birth">生日：</span>
		<input type="text" class="form-control" id="datepicker" name="birthday" autocomplete="off">
	</div>
	<div class="form-group">
		<span id="addr">快速收货地址：</span>
		<input type="text" class="form-control" id="addr1" name="addr1" placeholder="地址1" autocomplete="off">
		<input type="text" class="form-control" id="addr2" name="addr2" placeholder="地址2" autocomplete="off">
		<input type="text" class="form-control" id="addr3" name="addr3" placeholder="地址3" autocomplete="off">
	</div>
	<div class="form-group">
		<span id="expl">个人说明：</span>
		<textarea class="form-control" rows="3" id="explain" name="introduction" autocomplete="off"></textarea>
	</div>
	<div>
	    <span class="help-block" id="hidden"></span>
		<input type="submit" id="sub" class="btn btn-default" value="保存">
    </div>
  </form>
</div>

</body>
</html>