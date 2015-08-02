$(function(){
	$("#text1").focus(function(){
		$(this).css("border-color","rgb(255, 118, 42)");
	});
	$("#text1").blur(function(){
		$(this).css("border-color","white");
	});
	
	$("#btn").mouseenter(function(){
		$(this).css({"border-color":"white",
			"background-color":"green"});
	});
	
	$("#btn").mouseleave(function(){
		$(this).css({"border-color":"white", 
			"background-color":"transparent"});
	});
	
	
	$("#addrbutton").mouseenter(function(){
		$(this).css({"border-color":"white",
			"background-color":"rgb(245, 102, 23)"});
	});
	
	$("#addrbutton").mouseleave(function(){
		$(this).css({"border-color":"white",
			"background-color":"transparent"});
	});
	
	$("ul li").each(function () {  
        $(this).click(function(){   
            $("#myModal").modal("hide");
            $("#addrbutton").text($(this).text());
        });  
    }); 
	
	$("#search").submit(function(){
		$("#text2").val($("#addrbutton").text());
	});
	
});