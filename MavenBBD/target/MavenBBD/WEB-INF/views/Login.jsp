<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
<script src="js/jQuery/jquery-2.1.3.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
<script src="js/jquery-2.1.3.js"></script>
<script src="js/logincheck.js"></script>
</head>
<body>
<form action="LoginCheckServlet" method="post" id="form1" role="form" class="form-horizontal">
	<span class="help-block" id="hidden"></span>
	<div class="form-group">
		<input type="text" name="username" id="text1" class="form-control" placeholder="用户名" autocomplete="off" >
		<span class="help-block" id="hidden1"></span>
	</div>
	<div class="form-group">
		<input type="password" name="pass1" id="password1" class="form-control" placeholder="密码">
		<span class="help-block" id="hidden2"></span>
	</div>
		<input type="submit" id="sub" class="btn btn-default" value="提交">
</form>
</body>
</html>