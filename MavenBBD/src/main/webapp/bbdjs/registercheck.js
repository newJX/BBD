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
		function checkpassword2(){
			var flag=false;
			$("#password2").val($("#password2").val().replace(/\s*/g,""))
			if($("#password2").val()==null||$("#password2").val()==""){
				$("#hidden3").text("确认密码不能为空！");
				$("#hidden3").css({color:"red"});
				$("#password2div").removeClass().addClass("form-group has-error");
				flag=false;
				event.preventDefault();
			}
			else{
				$("#hidden3").text("");
				$("#password2div").removeClass().addClass("form-group has-success");
				flag=true;
			}
				return flag;
		}
		function checkuser(){
			$.ajax({
				cache: false,
				type: "POST",
				url:"RegjQueryServlet",	 
				dataType: "html",
				data:$('#form1').serialize(),	 
				async: false,
				error: function(request) {
				alert("请求发送失败！");
				},
				success: function(json) {
					flag=json;	 
				}
				});
			//返回true代表要注册的用户已经存在
			if(flag=="true"){
				$("#hidden").text("该用户已经存在！");
				$("#hidden").css({color:"red"});
				event.preventDefault();
			}
			else{
				alert("验证通过！");
			}
		}
		
		$("#text1").blur(checkusername);
		$("#password1").blur(checkpassword1);
		$("#password2").blur(checkpassword2);
		$("#form1").submit(function(){
			checkusername();
			checkpassword1();
			checkpassword2();
			if($("#password2").val()!=$("#password1").val()){
				$("#hidden3").text("两次密码输入不一致！");
				$("#hidden3").css({color:"red"});
				event.preventDefault();
			}else{
				if(checkusername()&&checkpassword1()&&checkpassword2()){
					checkuser();
				}
			}
		})
	});
