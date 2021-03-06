<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

 <!-- Bootstrap core CSS -->
 
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage2.css" rel="stylesheet">

<script>
	$(function(){
		$("#loginBtn").click(function(){
			location.href='login_form.do';
		})
	})
</script>
<title>아이디 찾기</title>
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
				<h3>아이디 찾기 검색결과</h3>
			</div>
			<div>
				<h5>
					${ id }
				</h5>
				<p class="w3-center">
					<button type="button" id=loginBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">Login</button>
					<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
				</p>
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