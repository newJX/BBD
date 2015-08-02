$(function(){
	function checkp1(){
		var flag=false;
		$("#password1").val($("#password1").val().replace(/\s*/g,""))
		if($("#password1").val()==null||$("#password1").val()==""){
			$("#hidden1").text("当前密码不能为空！");
			$("#hidden1").css({color:"red"});
			$("#p1").removeClass().addClass("form-group has-error");
			flag=false;
			event.preventDefault();
		}
		else{
			$("#hidden1").text("");
			$("#p1").removeClass().addClass("form-group has-success");
			flag=true;
		}
		return flag;
	}
	
	function checkp2(){
		var flag=false;
		$("#password2").val($("#password2").val().replace(/\s*/g,""))
		if($("#password2").val()==null||$("#password2").val()==""){
			$("#hidden2").text("新密码不能为空！");
			$("#hidden2").css({color:"red"});
			$("#p2").removeClass().addClass("form-group has-error");
			flag=false;
			event.preventDefault();
		}
		else{
			$("#hidden2").text("");
			$("#p2").removeClass().addClass("form-group has-success");
			flag=true;
		}
			return flag;
	}
	
	function checkp3(){
		var flag=false;
		$("#password3").val($("#password3").val().replace(/\s*/g,""))
		if($("#password3").val()==null||$("#password3").val()==""){
			$("#hidden3").text("确认新密码不能为空！");
			$("#hidden3").css({color:"red"});
			$("#p3").removeClass().addClass("form-group has-error");
			flag=false;
			event.preventDefault();
		}
		else{
			$("#hidden3").text("");
			$("#p3").removeClass().addClass("form-group has-success");
			flag=true;
		}
			return flag;
	}	
	
	function checkpassword(){
		var flag="false";
		$.ajax({
			cache: false,
			type: "POST",
			url:"LogjQueryServlet",	 
			dataType: "html",
			data:$('#form1').serialize(),	 
			async: false,
			error: function(request) {
			alert("ajax LogjQueryServlet error！！");
			},
			success: function(json) {
				flag=json;	 
			}
			});
		
		if(flag=="false"){
			$("#hidden").text("当前密码错误！");
			$("#hidden").css({color:"red"});
			event.preventDefault();
		}
		else{}
	}

	$("#password1").blur(checkp1);
	$("#password2").blur(checkp2);
	$("#password3").blur(checkp3);
	$("#form1").submit(function(){
		checkp1();
		checkp2();
		checkp3();
		if($("#password2").val()!=$("#password3").val()){
			$("#hidden3").text("两次密码输入不一致！");
			$("#hidden3").css({color:"red"});
			event.preventDefault();
		}else{
			if(checkp1()&&checkp2()&&checkp3()){
				checkpassword();
			}
		}
	})
});
