$(function(){
	$.ajax({
		cache: false,
		type: "POST", 
		url:"GetReleaseOrderServlet",	 
		data: {username:$("#username").val()},
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
	
	function addOrderDiv(id,addr,title,content,pay,date,validtime,status,recstatus,list){
		var div,div1;
		div=
		'<div class="order">'+
		'<input type="hidden" id="id_hidden" value="'+id+'"/>'+
		'<div id="addr"  class="label label-primary"><h5>'+addr+'</h5></div>'+
		'<div id="title">'+title+'</div>'+
		'<div id="content">'+content+'</div>'+
		'<div id="pay"><span>酬劳：</span>'+pay+'块(RMB)</div>'+
		'<div id="date">'+date+'</div>'+
		'<div id="validtime"><span>有效时间：</span>'+validtime+'小时</div>'+
		((status==0)?
		('<a id="a_status1" href=javascript:void(0)><B>进行中</B></a>'):
		('<a id="a_status" href=javascript:void(0)><B>已结束</B></a>'));
		if(recstatus==1){
			div1=addRecDiv(list);
			div=div+div1;
		}
		div=div+'</div>';
		return div;
	}
	
	function addRecDiv(list){
		var div2=
		 '<div id="receive">'+
		 '<div class="panel-group" id="accordion">';
		for(j=0;j<list.length;j++){
			div2+=
			('<div class="panel panel-default">'+
				'<div class="panel-heading">'+
					'<h5 class="panel-title">'+
						'<a data-toggle="collapse" data-parent="#accordion" href="#recpanel'+j+'" id="a_title">'+
							list[j].recusername+      
						'</a>'+
						'<p id="recdate">'+list[j].recdate+'</p>'+
					'</h5>'+
		        '</div>'+
		    '<div id="recpanel'+j+'" class="panel-collapse collapse al">'+
		        '<div class="panel-body">'+
		         	'<p><b>#联系方式</b></p>'+
		            '<p>'+list[j].contact+'</p>'+
		            '<p><b>#留言</b></p>'+
		            '<p>'+list[j].comment+'</p>'+
		         '</div>'+
		      '</div>'+
		   '</div>');
		}
		div2+=('</div></div>');
		return div2;
	}
	$(".al").collapse('show');
	
	$(".order").each(function(){
		$(this).children("#a_status1").click(function(){
			$.ajax({
				cache: false,
				type: "POST", 
				url:"ChangeOrderStatusServlet",	 
				data: {id:$(this).parent().children("#id_hidden").val()},
				dataType: "html",
				async: false,
				error: function(request) {
					alert("页面请求失败！");
				},
				success: function(json) {
					location.reload();
				}
				});
			
		})
	});
});