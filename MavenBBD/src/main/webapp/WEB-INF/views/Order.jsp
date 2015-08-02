<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布任务</title>
<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
<link rel="stylesheet" href="css/order.css">
<script src="js/order.js"></script>
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
			<a href="Login">登录</a>/<a href="Register">注册</a>
<% 
}
   else if((session.isNew()&&c.length==1)||(!session.isNew()&&c.length>1)){
		for(int i=0;i<c.length;i++){
			if(!c[i].getName().equals("JSESSIONID")){
				pageContext.setAttribute("username",URLDecoder.decode(c[i].getName(), "UTF-8"));
				out.print("<a href='Index'>"+URLDecoder.decode(c[i].getName(), "UTF-8")+"</a>");
%>
<a href="Personal_Info">个人中心</a>
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

   <form role="form" class="form-horizontal" id="form1" action="AddOrderServlet" method="post">
     <div class="input-group">
   		<div class="input-group-btn">
   			<button type="button" id="addrbutton" class="btn btn-default" tabindex="-1" data-toggle="modal"  data-target="#myModal">广州</button>
   			<button type="button" class="btn btn-default  dropdown-toggle" data-toggle="modal"  data-target="#myModal" data-toggle="dropdown" tabindex="-1" style="height:34px;" >
   			<span class="caret" ></span>
   			</button>
  		</div>
   	 	<input type="text" name="_title" class="form-control" placeholder="请输入尽可能详细的地址，方便他人查找您的任务" autocomplete="off">
   	 </div>
   	 <textarea id="area" name="_content" class="form-control" ></textarea>
   	 <input id="valid" type="text" name="_validtime" class="form-control" placeholder="有效期(小时)" autocomplete="off">
     <input id="pay" type="text" name="_pay" class="form-control" placeholder="酬劳(RMB)" autocomplete="off">
     <input type="submit" id="sub" class="btn btn-default" value="提交">
     <input type="hidden" name="_username" value=<%=pageContext.getAttribute("username")%>>
  	 <input type="hidden" name="_addr" id="addrhid">
   </form>


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
</body>
</html>