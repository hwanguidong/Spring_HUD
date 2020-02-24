/**
 * 
 */
var bno=1;
var str="";
$.getJSON("../replies/all/"+bno, function(data){
	
	console.log(data.length);
	
	$(data).each(function(){
		str+="<li data-rno='"+this.rno+"'class='replyLi'>"+this.rno+":"+this.replytext+"<button>수정</button></li>";
		
		
	});
	$("#replies").html(str);
	
	
	
});
$(document).ready(function(){
	
	//댓글쓰기 버튼클릭start
	$("#replyAddBtn").on("click",function(){
		
		var bno = $("#newBno").val();
		var replyer = $("#newReplyWriter").val();
		var replytext = $("#newReplyText").val();
		
		$.ajax({
			type:'post',
			url:'../replies',
			headers:{
				"Content-Type": "application/json",
				"X-HTTP-Method-Override":"POST"	},
			dataType:'text',
			data:JSON.stringify({bno:bno ,replyer:replyer, replytext:replytext}),
			success:function(data){
				
				if(data=='SUCCESS'){
					alert("등록완료");
				}else{
					alert("실패")
				}
				
				
			}		
			
			
		});
		
		
	});//댓글쓰기 버튼클릭end
	
	//댓글 수정 버튼클릭start
	$("#replies").on("click",".replyLi button", function(){
   //$("#replies").on("click",".replyLi $(:button)", function(){  input태크로 버튼을 만들었을때
		var reply = $(this).parent();
		var rno =reply.attr("data-rno");
		var replytext = reply.text();
		
		$(".modal-title").html(rno);
		$("#replytext").val(replytext);
		$("#modDiv").show("slow");
		alert(rno+":"+replytext);
		
		
		
	});
	$("#replyModBtn").on("click",function(){
	
		var rno = $(".modal-title").html();
		var replytext =$("#replytext").val();
		
		$.ajax({
			type:'put',
			url:'../replies/'+rno,
			headers: {
				"Content-Type":"application/json",
				"X-HTTP-Method-Override": "PUT"},
			data:JSON.stringify({replytext:replytext}),
			dataType:'text',
			success:function(data){
				console.log("result:"+data);
				if(data=='SUCCESS'){
					alert("수정되었습니다");
					$("#modDiv").hide("slow");
					
				}
			}});
		
	});	//댓글 수정 버튼클릭end
	
	
	
	$("#replyDelBtn").on("click",function(){
		
		var rno = $(".modal-title").html();
		var replytext =$("#replytext").val();
		
		$.ajax({
			type:'delete',
			url:'../replies/'+rno,
			headers: {
				"Content-Type":"application/json",
				"X-HTTP-Method-Override": "DELETE"},
			dataType:'text',
			success:function(data){
				console.log("data:"+data);
				if(data=='SUCCESS'){
					alert("삭제되었습니다");
					$("#modDiv").hide("slow");
					
				}
			}});
		
	});
	
});
	





