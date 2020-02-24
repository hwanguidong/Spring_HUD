/**
 * 
 */


$(document).ready(function(){
	

//수정버튼을 클릭했을떄
$("#modify").click(function(){
	
	$("#form1").attr("action","modify");
	$("#form1").attr("method","get");
	$("#form1").submit();
	
})

//삭제버튼을 클릭했을때

$("#delete").click(function(){
	form1.attr("action","delete")
})
	
	
	
})