$(function(){
		function checkusername(){
			    var flag=false;
				$("#text1").val($("#text1").val().replace(/\s*/g,""))
				if($("#text1").val()==null||$("#text1").val()==""){
					$("#hidden1").text("�û�������Ϊ�գ�");
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
				$("#hidden2").text("���벻��Ϊ�գ�");
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
				$("#hidden3").text("ȷ�����벻��Ϊ�գ�");
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
				alert("��������ʧ�ܣ�");
				},
				success: function(json) {
					flag=json;	 
				}
				});
			//����true����Ҫע����û��Ѿ�����
			if(flag=="true"){
				$("#hidden").text("���û��Ѿ����ڣ�");
				$("#hidden").css({color:"red"});
				event.preventDefault();
			}
			else{
				alert("����ע�ᣡ11");
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
				$("#hidden3").text("�����������벻һ�£�");
				$("#hidden3").css({color:"red"});
				event.preventDefault();
			}else{
				if(checkusername()&&checkpassword1()&&checkpassword2()){
					checkuser();
				}
			}
		})
	});
