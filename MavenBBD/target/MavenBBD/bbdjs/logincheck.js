$(function(){
	function checkusername(){
		var flag=false;
		$("#text1").val($("#text1").val().replace(/\s*/g,""))
		if($("#text1").val()==null||$("#text1").val()==""){
			$("#hidden1").text("用户名不能为空！");
			$("#hidden1").css({color:"red"});
			$("#userdiv").removeClass().addClass("form-group has-error");
			flag=false;
			event.preventDefault();
		}
		else{
			$("#hidden1").text("");
			$("#userdiv").removeClass().addClass("form-group has-success");
			flag=true;
		}
		return flag;
}
	function checkpassword1(){
		var flag=false;
		$("#password1").val($("#password1").val().replace(/\s*/g,""))
		if($("#password1").val()==null||$("#password1").val()==""){
			$("#hidden2").text("密码不能为空！");
			$("#hidden2").css({color:"red"});
			$("#password1div").removeClass().addClass("form-group has-error");
			flag=false;
			event.preventDefault();
		}
		else{
			$("#hidden2").text("");
			$("#password1div").removeClass().addClass("form-group has-success");
			flag=true;
		}
			return flag;
	}	
	
	function checkuser(){
		var flag=false;
		$.ajax({
			cache: false,
			type: "POST",
			url:"LogjQueryServlet",	 
			dataType: "html",
			data:$('#form1').serialize(),	 
			async: false,
			error: function(request) {
			alert("发送请求失败！");
			},
			success: function(json) {
				flag=json;	 
			}
			});
		//true表示验证通过 false表示用户名或者密码错误
		if(flag=="false"){
			$("#hidden").text("用户名或者密码错误！");
			$("#hidden").css({color:"red"});
			event.preventDefault();
		}
		else{
			alert("验证通过！");
		}
	}

	$("#text1").blur(checkusername);
	$("#password1").blur(checkpassword1);
	$("#form1").submit(function(){
		checkusername();
		checkpassword1();
		if(checkusername()&&checkpassword1()){
			checkuser();
		}
	})
});
