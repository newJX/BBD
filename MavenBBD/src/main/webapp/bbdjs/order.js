$(function(){
	$("ul li").each(function () {  
            $(this).click(function(){  
                $("#myModal").modal("hide");
                $("#addrbutton").text($(this).text());
            });  
        }); 
	
	$("#form1").submit(function(){
		$("#addrhid").val($("#addrbutton").text());
	});
});