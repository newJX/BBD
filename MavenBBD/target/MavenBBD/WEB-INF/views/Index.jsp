<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>BBD</title>
<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

<div id="banner">
<div id="status">
<%
	Cookie c[]=request.getCookies();
   if((session.isNew()&&c==null)||(!session.isNew()&&c.length==1)) 
	{
%>

  <span class="glyphicon glyphicon-user"></span><a href="Login"><B>��¼</B></a>
			
  <span class="glyphicon glyphicon-plus"></span><a href="Register"><B>ע��</B></a>
<% 
}
   else if((session.isNew()&&c.length==1)||(!session.isNew()&&c.length>1)){
		for(int i=0;i<c.length;i++){
			if(!c[i].getName().equals("JSESSIONID")){
				out.print("<a href='Index'>"+c[i].getName()+"</a>  ");
%>
<a href="Personal_Info">��������</a>
<a href="Order">��������</a>

<% 
				out.print("<a href='LogOutServlet'>�˳�</a>");
			}
			System.out.print(c[i].getName()+":"+c[i].getValue()+"\n");
		}
	}
   else{
	   System.out.println("error!!!!!!!");
   }
%>
</div>
</div>



<form id="search" class="form-search">
<input type="text" name="username" id="text1" class="form-control" placeholder="������Ҫ���ҵĵ�ַ" autocomplete="off" >
<button id="btn" class="btn btn-success btn-large" type="button">����</button>
</form>

</body>
</html>