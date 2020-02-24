<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HUD</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<style>
 body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
 ul { padding:0; margin:0; list-style:none;  }

 div#root { width:90%; margin:0 auto; }
 
 header#header { font-size:60px; padding:20px 0; }
 header#header h1 a { color:#000; font-weight:bold; }
 
 nav#nav { padding:10px; text-align:right; }
 nav#nav ul li { display:inline-block; margin-left:10px; }

   section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
 section#container::after { content:""; display:block; clear:both; }
 aside { float:left; width:200px; }
 div#container_box { float:right; width:calc(100% - 200px - 20px); }
 
 aside ul li { text-align:center; margin-bottom:10px; }
 aside ul li a { display:block; width:100%; padding:10px 0;}
 aside ul li a:hover { background:#eee; }
 
 footer#footer { background:#f9f9f9; padding:20px; }
 footer#footer ul li { display:inline-block; margin-right:10px; }
</style>
<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
</style>
<style>
#container_box table{width: 900px;}
#container_box table th{font-size:20px; font-weight: bold;
						text-align: center; padding: 10px; border-bottom: 2px solid #666;}
#container_box table tr:hover{background: #eee;}
#container_box table td {padding: 10px; text-align: center;}
#container_box table img{width: 150px; height: auto;}

#container_box ul li { margin-bottom:20px; border:10px solid #eee; }
.replyInfo { background:#eee; padding:10px; font-size:18px; }
.replyInfo span { font-size:20px; font-weight:bold; margin-right:20px; }
.replyContent { padding:10px; }

.replyControll {text-align:right; padding:10px; }
.replyControll button { border:2px solid #999; background:#fff; }

</style>

<style>
#container_box table td { width:100px; }
</style>

</head>
<body>
<div id="root">
	<header id="header_box">
		<div id="header_box">
		<%@ include file="../admin/include/header.jsp" %>
		</div>
	</header>	
		
	<nav id="nav">
		<div id="nav_box">
		<%@ include file="../admin/include/nav.jsp" %>		
		</div>	
	</nav>
	
	<section id="container">
	
	<aside id="aside">
			<%@include file="../admin/include/aside.jsp" %>
		</aside>
			
	
	<div id="container_box">
	
 <ul>
 
 
  <c:forEach items="${reply}" var="reply">
  <li>
   <div class="replyInfo">
    <p>
     <span>작성자</span>${reply.email} (${reply.userId})
    </p>
    <p>
     <span>작성된 상품</span> <a href="/hud/shop/view?n=${reply.gdsNum}">바로가기</a>
    </p>
   </div>
   <div class="replyContent">
    ${reply.repCon}
   </div>
   <div class="replyControll">
 <form role="form" method="post">
  <input type="hidden" name="repNum" value="${reply.repNum}" />
  <button type="submit" class="delete_${reply.repNum}_btn">삭제</button>
 </form>
	</div>
   
  </li>     
  </c:forEach>
 </ul>
</div>
		
	
		
			
	</section>
	
	<footer id="footer">
		<div id="footer_box">
		<%@ include file="../admin/include/footer.jsp" %>
		
		</div>
	
	</footer>
	
	
</div>

</body>
</html>