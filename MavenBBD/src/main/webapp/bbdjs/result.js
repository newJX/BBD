$(function(){
	$.ajax({
		cache: false,
		type: "post", 
		url:"GetOrderServlet",	 
		data: {address:$("#address").val(),keyword:$("#keyword").val()},
		dataType: "json",
		async: false,
		error: function(request) {
			alert("页面请求失败！");
		},
		success: function(json) {
			for(i=0;i<json.length;i++){
				$("#All_Assign").append(addOrderDiv(
						json[i].id,
						json[i].username,
						json[i].addr,
						json[i].title,
						json[i].content,
						json[i].pay,
						json[i].status,
						json[i].date,
						json[i].validtime
			));
			}
		}
		});
	
	function addOrderDiv(id,username,addr,title,content,pay,status,date,validtime){
		var div;
		div=
		'<div id="Assign">'+
		'<input type="hidden" id="_id" value="'+id+'">'+
		'<div id="_addr" class="label label-primary"><h5>'+addr+'</h5></div>'+
		(status==0?
		('<div id="_status" class="label label-success"><h5>进行中</h5></div>'):		
		('<div id="_status" class="label label-danger"><h5>已结束</h5></div>')
		)+
		'<div id="_title">'+title+'</div>'+
		'<div id="_user">发布者：'+username+'</div>'+
		'<div id="_date">发布时间：'+date+'</div>'+
		'<div id="_content">'+content+'</div>'+
		'<div id="_pay">酬劳：'+pay+'(RMB)</div>'+
		'<div id="_validtime">有效时间：'+validtime+'(小时)</div>'+
		(status==0?
		('<button id="accept" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal'+id+'">接受该任务</button>'):
			'<button id="accept" type="button" class="btn btn-warning" disabled="disabled" "data-toggle="modal" data-target="#myModal'+id+'">接受该任务</button>')+
		'<!-- 模态框（Modal） -->'+
		'<div class="modal fade" id="myModal'+id+'" tabindex="-1" role="dialog"'+ 
		'aria-labelledby="myModalLabel" aria-hidden="true">'+	   
		'<div class="modal-dialog">'+	 
	    '<div class="modal-content">'+  	  
		'<div class="modal-header">'+   	  	
	    '<h4 class="modal-title" id="myModalLabel">填写相关信息</h4>'+       		
		'</div>'+       	 
		'<div class="modal-body">'+      	 
		'<form id="form1" role="form" class="form-horizontal">'+
		'<div class="form-group">'+
		'<textarea id="area1" class="form-control" placeholder="联系方式" ></textarea>'+
		'</div>'+
		'<div class="form-group">'+
	    '<textarea id="area2" class="form-control" placeholder="留言" ></textarea>'+
	    '</div>'+
	    '</form>'+        	  	
		'</div>'+      	 
		'<div class="modal-footer">'+      	 
		'<button type="button" class="btn btn-default" '+        
		'data-dismiss="modal">关闭'+          
		'</button>'+       
		'<button id="subbutton" type="button" class="btn btn-primary">'+       
		'提交'+        
		'</button>'+     
		'</div>'+    
		'</div><!-- /.modal-content -->'+   
		'</div><!-- /.modal -->'+
		'</div>'
		return div;
	}
	
	$("#All_Assign #subbutton").each(function(){
		$(this).click(function(){
			alert($(this).parents("#All_Assign").parent().children("#_username").val());
			$.ajax({
				cache: false,
				type: "POST", 
				url:"AcceptOrderServlet",	 
				data: {
				 username:$(this).parents("#All_Assign").parent().children("#_username").val(),
			     id:$(this).parents("#Assign").children("#_id").val(),
			     contact:$(this).parents(".modal-content").children(".modal-body").children("#form1").children(".form-group").children("#area1").val(),
			     comment:$(this).parents(".modal-content").children(".modal-body").children("#form1").children(".form-group").children("#area2").val()
				},
				dataType: "html",
				async: false,
				error: function(request) {
					alert("页面请求失败！");
				},
				success: function(json) {
					if(json=="true"){
						alert("任务接受成功！");
						location.href="Index";
					}
				}
				});
		});
	});
});