<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="test.jsp" ">
<button id="btn" name="btn1" >aaa</button>
<input type="hidden" id="hid1" name="hid">
<input type="text" name="txt" >
<input type="submit" onclick="change()">
</form>

</body>
<script>
	function change(){
		document.getElementById('hid1').value=document.getElementById('btn').innerHTML;
	}
</script>
</html>