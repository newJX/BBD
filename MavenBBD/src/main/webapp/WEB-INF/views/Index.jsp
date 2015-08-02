<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBD</title>
<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

<div id="banner">
<div id="status">
<a href="Index" id="bbd"  style="margin-right:520px;font-family:HVD Bodedo"><B>BBD.COM</B></a>
<%
	Cookie c[]=request.getCookies();
   if((session.isNew()&&c==null)||(!session.isNew()&&c.length==1)) 
	{
%>

  <span class="glyphicon glyphicon-user"></span><a href="Login"><B>登录</B></a>
			
  <span class="glyphicon glyphicon-plus"></span><a href="Register"><B>注册</B></a>
<% 
}
   else if((session.isNew()&&c.length==1)||(!session.isNew()&&c.length>1)){
		for(int i=0;i<c.length;i++){
			if(!c[i].getName().equals("JSESSIONID")){
				out.print("<a href='Index'>"+URLDecoder.decode(c[i].getName(), "UTF-8")+"</a>");
%>
<a href="Personal_Info">个人中心</a>
<a href="Order">发布任务</a>

<% 
				out.print("<a href='LogOutServlet'>退出</a>");
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

<div id="status_line"></div>

<form id="search" class="form-search" method="post" action="Assign_Result">
<div class="input-group-btn" id="addr">
   			<button type="button"  id="addrbutton" class="btn btn-default" tabindex="-1" data-toggle="modal"  data-target="#myModal">广州</button>
   			<button type="button" id="addr1" class="btn btn-default  dropdown-toggle" data-toggle="modal"  data-target="#myModal" data-toggle="dropdown" tabindex="-1">
   			<span class="caret" ></span>
   			</button>
 </div>
<input type="text" name="keyword1" id="text2" style="display:none"/>
<input type="text" name="keyword2" id="text1" class="form-control" placeholder="请输入要查找任务的标题关键字" autocomplete="off" >
<input type="submit" value="查找" id="btn" class="btn btn-success btn-large"  />
<!-- 模态框（Modal） -->
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
 	   aria-labelledby="myModalLabel" aria-hidden="true">
  	 <div class="modal-dialog">
    	  <div class="modal-content">
     	  	  <div class="modal-header">
          		  <h4 class="modal-title" id="myModalLabel">选择地区 </h4>
          	  </div>
         	  <div class="modal-body">
           	  	 <%@ include file="area.jsp"%>
          	  </div>
          </div><!-- /.modal-content -->
     </div><!-- /.modal -->
</form>

</body>
</html>