$(function(){
    $( "#datepicker" ).datepicker({ 
    	regional: 'zh-CN',
    	maxDate: "0D",
    	changeMonth: true,
    	changeYear: true,
    	dateFormat: 'yy-mm-dd',
    	firstDay: 1 
    }
    );
    
    $.ajax({
		cache: false,
		type: "POST",
		url:"GetPersonalInfoServlet",	 
		data: {username:$("#username").val()},
		dataType: "json",
		async: false,
		error: function(request) {
		alert("发送请求失败！");
		},
		success: function(json) {
			if(json.sex=="female"){
				$("#male").removeAttr("checked");
				$("#female").attr("checked",true);
			}else if(json.sex=="male"){
				$("#female").removeAttr("checked");
				$("#male").attr("checked",true);
			}else{
				$("#female").removeAttr("checked");
				$("#male").removeAttr("checked");
			}
			$("#datepicker").val(json.birthday);
			$("#addr1").val(json.addr1);
			$("#addr2").val(json.addr2);
			$("#addr3").val(json.addr3);
			$("#explain").val(json.introduction);
		}
		});
    
    
    
    
    
    
    
    
    
    
    
	$("#hidden").text("");
	$("#info_form").submit(function(){
		var flag=false;
		$.ajax({
			cache: false,
			type: "POST",
			url:"UpdatePersonInfoServlet",	 
			dataType: "html",
			data:$('#info_form').serialize(),	 
			async: false,
			error: function(request) {
			alert("发送请求失败！");
			},
			success: function(json) {
				flag=json;	 
			}
			});
		event.preventDefault();
		if(flag=="true"){
			$("#hidden").text("修改成功！");
			$("#hidden").css({color:"red"});
		}else if(flag=="false"){
			$("#hidden").text("修改失败！");
			$("#hidden").css({color:"red"});
		}
	});
});