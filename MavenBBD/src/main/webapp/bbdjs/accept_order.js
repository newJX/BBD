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
			if(json.length==0){
				$("#accept").append("" +
						"<div style='margin-left:160px;margin-top:160px;'>"+
						"您暂时还没有接受任何任务！</div>"
						);
			}
			for(i=0;i<json.length;i++){
				$("#accept").append(addOrderDiv(
						json[i].addr,
						json[i].title,
						json[i].content,
						json[i].username,
						json[i].pay,
						json[i].date,
						json[i].recdate,
						json[i].validtime,
						json[i].contact,
						json[i].comment,
						json[i].status
			));
			}
		}
		});
	
	function addOrderDiv(addr,title,content,username,pay,date,recdate,validtime,contact,comment,status){
		var div;
		div=
		'<div class="order">'+
		'<div id="addr" class="label label-primary"><h5>'+addr+'</h5></div>'+
		((status==0)?
		 ('<div id="_status" class="label label-success"><h5>进行中</h5></div>'):
		 ('<div id="_status" class="label label-danger"><h5>已结束</h5></div>'))+
		'<div id="title">'+title+'</div>'+
		'<div id="username">'+username+'</div>'+
		'<div id="date">'+date+'</div>'+
		'<div id="content">'+content+'</div>'+
		'<div id="pay"><span>酬劳：</span>'+pay+'块(RMB)</div>'+
		'<div id="validtime"><span>有效时间：</span>'+validtime+'小时</div>'+
		'<div id="contact">联系方式：'+contact+'</div>'+
		'<div id="comment">留言：'+comment+'</div>'+
		'<div id="recdate">接受时间：'+recdate+'</div>'+
		'</div>'
		return div;
	}
});