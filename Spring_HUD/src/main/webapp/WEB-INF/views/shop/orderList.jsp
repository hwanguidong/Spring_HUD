


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>hud</title>

  <!-- Bootstrap core CSS -->
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../resources/css/shop-homepage.css" rel="stylesheet">
   <link href="../resources/css/shop-homepage2.css" rel="stylesheet">


<style>

 section#content ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 section#content .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }
</style>
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
    
      <a class="navbar-brand" href="/hud/homepage">HWANG</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        
        <c:if test="${member ==null }">
          <li class="nav-item active">
            <a class="nav-link" href="/hud/homepage">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>  
          <li class="nav-item">
            <a class="nav-link" href="/hud/member/login_form.do">login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/hud/member/memberJoinForm">join</a>
          </li>
          <li class="nav-item">
           <a class="nav-link" href="/hud/board/list">Q&A</a>
           </li>
          
          </c:if>
          
          <c:if test="${member !=null }">          
          	<c:if test="${member.hos==1 }">
           <li class="nav-item">
           	<a class="nav-link" href="/hud/admin/index">관리자화면</a>
           </li>
         	 </c:if>
         	 <li class="nav-item">
           	<a class="nav-link" href="/hud/board/list">Q&A</a>
           </li>
           <li class="nav-item">
           	<a class="nav-link" href="/hud/shop/cartList">카트리스트</a>
           </li>
           <li class="nav-item">
           	<a class="nav-link" href="/hud/shop/orderList">주문내용</a>
           </li>
           <li class="nav-item">
           	<a class="nav-link" href="/hud/member/mypage.do">마이페이지(${member.id}님)</a>
           </li>
           <li class="nav-item">
           	<a class="nav-link" href="/hud/member/logout.do">logout</a>
           </li>
         </c:if>
          
         
        </ul>
      </div>
    </div>
  </nav>
	<header>
		 <%@ include file="../include/header2.jsp" %>
		</header>



  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-md-3">

        <h1 class="my-4">HWANGSHOP</h1>
       

<div id="container_box">
	

			
		
			
		</div>		
	</section>


      </div>
      <!-- /.col-lg-3 -->
      <div class="col-md-1">
		</div>
		<div class="col-md-8">
		 <div class="row">
	<section id="content">
 
 <ul class="orderList" >
  <c:forEach items="${orderList}" var="orderList">
  <li >
  <div id=>
   <p><span>주문번호</span><a href="/hud/shop/orderView?n=${orderList.orderId}">${orderList.orderId}</a></p>
   <p><span>수령인</span>${orderList.orderRec}</p>
   <p><span>주소</span>(${orderList.userAddr1}) ${orderList.userAddr2} ${orderList.userAddr3}</p>
   <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p>
   <p><span>상태</span>${orderList.delivery}</p>
   
   
   
  </div>
  </li>
  </c:forEach>
 </ul>

</section>

		</div>
      

    </div>
    
    <!-- /.row -->

  </div>
  <!-- /.container -->
</div>
  <!-- Footer -->
  <footer class="py-5 bg-dark">
   <%@ include file="../include/footer.jsp" %>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>