<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>

<script type="text/javascript"> 

imgslide(); //페이지가 로딩될때 함수를 실행합니다

function imgslide(){

  $val = $("#slide").attr("val"); //현재 이미지 번호를 가져옵니다

  $mx = $("#slide").attr("mx"); //총 이미지 개수를 가져옵니다

	$("#img"+$val).hide(); //현재 이미지를 사라지게 합니다.

	if( $val == $mx ){ $val = 1; } //현재이미지가 마지막 번호라면 1번으로 되돌립니다.

	else{ $val++; } //마지막 번호가 아니라면 카운트를 증가시켜줍니다

	$("#img"+$val).fadeIn(500); //변경된 번호의 이미지영역을 나타나게 합니다.괄호 안에 숫자는 페이드인 되는 시간을 나타냅니다.

	$("#slide").attr('val',$val); //변경된 이미지영역의 번호를 부여합니다.

	setTimeout('imgslide()',1000); //1초 뒤에 다시 함수를 호출합니다.(숫자값 1000당 1초)

}

</script>


<style>
  
  #slide{     position:relative;    width: 500px;   }

  #slide li{     position:absolute;   top:0;   left:0;   display:none;  -webkit-display:block;   }

  #slide img{    width:500px;    height: 300px;  } 
</style>


</head>
<body>
<div id="slide" val="1" mx="3">
<ul>
	<li id="img1"><img src="./resources/imgUpload/hodori.jpg" alt=""/></li>
	<li id="img2"><img src="./resources/imgUpload/tree1.jpg" alt=""/></li>
	<li id="img3"><img src="./resources/imgUpload/tree2.jpg" alt=""/></li>
</ul>
</div>

</body>
</html>