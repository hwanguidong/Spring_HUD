<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage2.css" rel="stylesheet">


<script>
	$(function(){
		if(${msg ne null}){
			alert('${msg}');
		};
		
		if($("#pwForm").submit(function(){
			if($("#pw").val() !== $("#pw2").val()){
				alert("비밀번호가 다릅니다.");
				$("#pw").val("").focus();
				$("#pw2").val("");
				return false;
			}else if ($("#pw").val().length < 8) {
				alert("비밀번호는 8자 이상으로 설정해야 합니다.");
				$("#pw").val("").focus();
				return false;
			}else if($.trim($("#pw").val()) !== $("#pw").val()){
				alert("공백은 입력이 불가능합니다.");
				return false;
			}
		}));
		if($("#dmForm").submit(function(){
			if(!confirm("정말 탈퇴하시겠습니까?")){
			 	return false;	
			}
		}));
		
		
	})
	
	$(function(){
	
	$("#email").keyup(function(){
			$.ajax({
				url : "./check_email.do",
				type : "POST",
				data : {
					email : $("#email").val()
				},
				success : function(result) {
					if (result == 1) {
						$("#email_check").html("중복된 이메일이 있습니다.");
						$("#chan").attr("disabled","disabled");
					} else {
						$("#email_check").html("사용가능한 이메일입니다");
						$("#chan").removeAttr("disabled");
					}
				},
			})
		});
	})
	
</script>
<title>마이페이지</title>
</head>

<body>

<div id="root">
	<header id="header_box">
		<div id="header_box">
		<%@ include file="../include/header.jsp" %>
		</div>
	</header>	
		
	<nav id="nav">
		<div id="nav_box">
		<%@ include file="../include/Memindex.jsp" %>		
		</div>	
	</nav>
	
	<section id="container">		
		<div id="container_box">





	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>My Page</h3>
			</div>
			<div>
				<form id="myForm" action="./update_mypage.do" method="post">
					<p>
						<label>ID</label> 
						<input class="w3-input" type="text" id="id" name="id" readonly value="${ member.id }"> 
					</p>
					<p>
						<label>Email</label> 
						<input class="w3-input" type="text" id="email" name="email" value="${ member.email }" required> 
						<span id="email_check" class="w3-text-red"></span>
					</p>
					<p class="w3-center">
						<button type="submit" id="chan" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">회원정보 변경</button>
					</p>
				</form>
				<br />
				<form id="pwForm" action="./update_pw.do" method="post">	
					<input type="hidden" name="id" value="${ member.id }">
					<p>
						<label>Password</label>
						<input class="w3-input" id="old_pw" name="old_pw" type="password" required>
					</p>
					<p>
						<label>New Password</label> 
						<input class="w3-input" id="pw" name="pw" type="password" required>
					</p>
					<p>
						<label>Confirm</label>
						<input class="w3-input" type="password" id="pw2" type="password" required>
					</p>
					<p class="w3-center">
						<button type="submit" id="joinBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">비밀번호 변경</button>
					</p>
				</form>
					
					<form id="dmForm" action="./delmem.do" method="post">	
						<input type="hidden" name="id" readonly="readonly" value="${member.id}">
						<p>
						<label>Password</label>
						<input class="w3-input"  name="pw" type="password" required>
						</p>
						 <p class="w3-center">
						 <button type="submit" id="delmemBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">회원 탈퇴</button>
						 </p>
						
					</form>
				
				
			</div>
		</div>
	</div>
	
	
	
	</div>		
	</section>
</div>	
	<footer id="footer">
		<div id="footer_box">
		<%@ include file="../include/footer.jsp" %>
		
		</div>
	
	</footer>
	
	
</body>
</html>