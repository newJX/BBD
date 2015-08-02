$(function(){
	$.ajax({
		cache: false,
		type: "POST", 
		url:"GetAcceptOrderServlet",	 
		data: {recname:$("#username").val()},
		dataType: "json",
		async: false,
		error: function(request) {
			alert("页面请求失败！");
		},
		success: function(json) {
			for(i=0;i<json.length;i++){
				$("#release").append(addOrderDiv(
						json[i].id,
						json[i].addr,
						json[i].title,
						json[i].content,
						json[i].pay,
						json[i].date,
						json[i].validtime,
						json[i].status,
						json[i].recstatus,
						json[i].list
			));
			}
		}
		});
});