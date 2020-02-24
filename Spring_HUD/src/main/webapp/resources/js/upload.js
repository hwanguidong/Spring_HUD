/**
 * 
 */


function checkImageType(fileName){
	alert("aaa");
	var pattern=/jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
	
}

function getImageLink(fileName){
	if(!checkImageType(fileName)){
		return;
	}
	var front=fileName.substr(0,12);
	var end=fileName.substr(14);
	
	alert("front="+front);
	alert("end="+end);
	
	return front+end;
}
function getOriginalName(fileName){
	alert("fileName="+fileName);
	return fileName;
}



$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
	
	
		
});

$(".fileDrop").on("drop", function(event){
	event.preventDefault();
		
	var files=event.originalEvent.dataTransfer.files;
	var file = files[0];
	console.log(file);
	
	var formData=new FormData();
	formData.append("file",file);
	
	$.ajax({
		url:'uploadAjax',
		data:formData,
		dataType:'text',
		processData:false,
		contentType:false,
		type:'POST',
		success:function(data){
			//console.log(data);
			alert(data);
			alert(checkImageType(data));
			
		var str="";
		
		if(checkImageType(data)){
			str="<div>"+"<img src='displayFile?fileName="+getImageLink(data)+"'/>"
			+"<small data-src=\'"+data+"\'>x</small>"+"</div>";
		}else{
			str="<div><a href='displayFile?fileName="+data+"'>"
			+getOriginalName(data)+"</a></div>";
		}
			
		$(".uploadList").append(str);	
			
			
		}
		
	})
	
	
	
});// drop end

//small태그를 click했을때
$(".uploadList").on("click","small",function(event){
	alert("delete111");
	var that =$(this);
	
	$.ajax({
		url:"deleteFile",
		type:"post",
		data:{fileName:$(this).attr("data-src")},
		dataType:"text",
		success:function(result){
			if(result=="deleted"){
				alert("delete");
				that.parent("div").remove();
			}
		}
		
		
		
	});
	
	
});












