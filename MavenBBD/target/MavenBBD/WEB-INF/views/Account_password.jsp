<%@ page language="java" contentType="text/html; charset=GBK"  pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�������</title>
<script src="js/jquery-2.1.3.js"></script>
<script src="js/accountcheck.js"></script>

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Account.css">
</head>
<body>
<div id="banner">
<div id="status">
<%--������Ҫ���û��Ƿ��Ѿ���¼�жϣ���ֱֹ��ͨ�����������logoutservlet--%>
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
<a href="Order">��������</a>
<a href='LogOutServlet'>�˳�</a>
</div>
</div>

<div id="menu">
<div class="panel panel-primary" style="width:180px">
   <div class="panel-heading" >
      <h3 class="panel-title" ><h3 style="margin-top:1px;margin-bottom:1px;margin-left:10px">�����ѯ</h3></h3>
   </div>
   <a  href="Account_order" class="panel-body"> 
      <h4 style="margin-top:0px;margin-bottom:0px;line-height:0.5;margin-left:50px;" ><B>��������</B></h4> 
   </a> 
</div>  
<div class="panel panel-primary" style="width:180px">
   <div class="panel-heading" >
      <h3 class="panel-title" ><h3 style="margin-top:1px;margin-bottom:1px;margin-left:10px">�������</h3></h3>
   </div>
   <a  href="Account_password" class="panel-body"> 
      <h4 style="margin-top:0px;margin-bottom:0px;line-height:0.5;margin-left:50px;" ><B>�޸�����</B></h4> 
   </a> 
</div>
</div>

<form action="ChangePasswordServlet" method="post" id="form1" role="form" class="form-horizontal">
	<span class="help-block" id="hidden"></span>
	<div id="p1" class="form-group">
		<input type="text" name="pass1" id="password1" class="form-control" placeholder="��ǰ����" autocomplete="off" >
		<span class="help-block" id="hidden1"></span>
	</div>
	<div id="p2" class="form-group">
		<input type="password" name="pass2" id="password2" class="form-control" placeholder="������">
		<span class="help-block" id="hidden2"></span>
	</div>
	<div id="p3" class="form-group">
		<input type="password" name="pass3" id="password3" class="form-control" placeholder="ȷ��������">
		<span class="help-block" id="hidden3"></span>
	</div>
		<input type="hidden" id="result" value=<%=request.getAttribute("result")%>>
		<%System.out.print(request.getAttribute("result")+"flag"); %>
		<input type="hidden" name="username" value=<%=pageContext.getAttribute("username")%>>
		<input type="submit" id="sub" class="btn btn-default" value="�ύ">
</form>


</body>
</html>