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
 

</style>
<style>
/*
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
*/
 .orderInfo { border:5px solid #eee; padding:10px 20px; margin:20px 0;}
 .orderInfo span { font-size:20px; font-weight:bold; display:inline-block; width:90px; }
 
 .orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:1px solid #999; }
 .orderView li::after { content:""; display:block; clear:both; }
 
 .thumb { float:left; width:200px; }
 .thumb img { width:200px; height:200px; }
 .gdsInfo { float:right; width:calc(100% - 220px); line-height:2; }
 .gdsInfo span { font-size:20px; font-weight:bold; display:inline-block; width:100px; margin-right:10px; }
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
		<%@ include file="../include/Memindex.jsp" %>		
		</div>	
	</nav>
	
	<section id="container">
	
			<aside id="aside">
			<%@include file="../admin/include/aside.jsp" %>
		</aside>	
	<div id="container_box">
	
	<section id="content">

 <div class="orderInfo">

  <c:forEach items="${orderView}" var="orderView" varStatus="status">
  
  	<c:if test="${status.first}">
 	<p><span>주문자</span>${orderView.userId}</p>
 	<p><span>수령인</span>${orderView.orderRec}</p>
 	<p><span>주소</span>(${orderView.userAddr1}) ${orderView.userAddr2} ${orderView.userAddr3}</p>
 	<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.amount}" /> 원</p>
 	<p><span>상태</span>${orderView.delivery}</p>
 
	 <div class="deliveryChange">
 		<form role="form" method="post" class="deliveryForm">
 
  		<input type="hidden" name="orderId" value="${orderView.orderId}" />
  		<input type="hidden" name="delivery" class="delivery" value="" />
  
  		 <button type="button" class="delivery1_btn">배송 중</button>
 		 <button type="button" class="delivery2_btn">배송 완료</button>
  
  	<script>
   		$(".delivery1_btn").click(function(){
    	$(".delivery").val("배송 중");
   		 run();
  		 });
   
  		 $(".delivery2_btn").click(function(){
   		 $(".delivery").val("배송 완료");
   		 run();
    
  		 });
   
 	  function run(){
 	   $(".deliveryForm").submit();
  	 }
  
  </script>
 </form>
</div>
	</c:if>
   
  </c:forEach>
 
 </div>
 
 <ul class="orderView">
  <c:forEach items="${orderView}" var="orderView">     
  <li>
   <div class="thumb">
    <img src="../resources/imgUpload/${orderView.gdsThumbImg}" />
   </div>
   <div class="gdsInfo">
    <p>
     <span>상품명</span>${orderView.gdsName}<br />
     <span>개당 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice}" /> 원<br />
     <span>구입 수량</span>${orderView.cartStock} 개<br />
     <span>최종 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice * orderView.cartStock}" /> 원                  
    </p>
   </div>
  </li>     
  </c:forEach>
 </ul>
</section>


			
		
			
		</div>		
	</section>
	
	<footer id="footer">
		<div id="footer_box">
		<%@ include file="../include/footer.jsp" %>
		
		</div>
	
	</footer>
	
	
</div>

</body>
</html>