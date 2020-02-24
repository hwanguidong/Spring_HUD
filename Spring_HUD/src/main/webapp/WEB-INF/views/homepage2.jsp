<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>hud</title>

  <!-- Bootstrap core CSS -->
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/shop-homepage.css" rel="stylesheet">
   <link href="./resources/css/shop-homepage2.css" rel="stylesheet">

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

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-md-3">

        <h1 class="my-4">HWANGSHOP</h1>
        <div class="list-group" id="aside">         
         
        <ul>
  		<li><a href="/hud/shop/list?c=100&l=1" >아우터</a>
  			<ul class="low">
  				<li><a href="/hud/shop/list?c=101&l=2" class="list-group-item">자켓</a></li>
  				<li><a href="/hud/shop/list?c=102&l=2"class="list-group-item">패팅</a></li>
  				<li><a href="/hud/shop/list?c=103&l=2"class="list-group-item">가디건</a></li>
  			</ul>
  		</li>
  		
  		<li><a href="/hud/shop/list?c=200&l=1">하의</a>
  			<ul class="low">
  				<li><a href="/hud/shop/list?c=201&l=2"class="list-group-item">반바지</a></li>
  				<li><a href="/hud/shop/list?c=202&l=2"class="list-group-item">청바지</a></li>
  				<li><a href="/hud/shop/list?c=203&l=2"class="list-group-item">면바지</a></li>
  			
  			</ul>
  		</li>
  		
  		<li><a href="/hud/shop/list?c=300&l=1" >티셔츠</a>
  			<ul class="low">
  				<li><a href="/hud/shop/list?c=301&l=2">기모</a></li>
  				<li><a href="/hud/shop/list?c=302&l=2">니트</a></li>
  				
  			</ul>
  		</li>
 	</ul>
		
        </div>

      </div>
      <!-- /.col-lg-3 -->
		<div class="col-md-1">
		</div>
      <div class="col-md-8">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img id="asd"class="d-block img-fluid" src="./resources/imgUpload/hodori.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="./resources/imgUpload/tree1.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="./resources/imgUpload/tree2.jpg" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
 <c:forEach items="${list}" var="list">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="/hud/shop/view?n=${list.gdsNum}"><img class="card-img-top" src="./resources/imgUpload/${list.gdsThumbImg}" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                   <a href="/hud/shop/view?n=${list.gdsNum}">${list.gdsName}</a>
                </h4>
                <h5>${list.gdsPrice }</h5>
                <p class="card-text">${list.gdsDes} </p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
           
          </div>
          </c:forEach>



        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">     
      <ul class="m-0 text-center text-white">
	<li>사이트소개</li>
	<li>이용약관</li>
	<li>HUD site</li>
</ul>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="./resources/vendor/jquery/jquery.min.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>