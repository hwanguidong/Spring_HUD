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
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/shop-homepage.css" rel="stylesheet">
   <link href="./resources/css/shop-homepage2.css" rel="stylesheet">

 <style >
 #col-lg-4 col-md-6 mb-4{width: 300px;}
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
		<div id=box>
		 <%@ include file="./include/header2.jsp" %>
		 </div>
		</header>
		
  <!-- Page Content -->
  <div class="container">

    <div class="row">

    
      <!-- /.col-lg-3 -->
		
      
              	      

  <li><h1 class="my-2"><br><a href="/hud/homepage">HWANGSHOP</a> <form action="homepage" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
            
            	<input type="hidden" name="pageNum"  value="${page.cri.getPageNum() }">
            	<input type="hidden" name="Amount" value="${page.cri.getAmount() }">
            	
              <input type="text" name="keyword" class="form-control bg-light border-0 small" placeholder="상품검색.." aria-label="Search" aria-describedby="basic-addon2"  >
              
              
              <div class="input-group-append" >
                <input class="btn btn-secondary" type="submit" value="검색"> 
              </div>
            </div>
          </form>
  		</h1></li>
  

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
            <a href="/hud/shop/view?n=20">  <img id="asd"class="d-block img-fluid" src="./resources/imgUpload/배너3.jpg" alt="First slide"></a>
            </div>
            <div class="carousel-item">
            <a href="/hud/shop/view?n=20">  <img class="d-block img-fluid" src="./resources/imgUpload/배너1.jpg" alt="Second slide"></a>
            </div>
            <div class="carousel-item">
             <a href="/hud/shop/view?n=21">  <img class="d-block img-fluid" src="./resources/imgUpload/배너2.jpg" alt="Third slide"></a>
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

        <div class="row" id="list">
 <c:forEach items="${list}" var="list">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="/hud/shop/view?n=${list.gdsNum}"><img class="card-img-top" src="./resources/imgUpload/${list.gdsThumbImg}" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                   <a href="/hud/shop/view?n=${list.gdsNum}">${list.gdsName}</a>
                </h4>
                <c:if test="${list.gdsPrice>70000 }">
                <h5><del>${list.gdsPrice }원</del> &nbsp;&nbsp; <ins>${list.gdsPrice-2000 }원</ins></h5>
                </c:if>
                  <c:if test="${list.gdsPrice<=70000 }">
                  <h5>${list.gdsPrice }원</h5>
                  </c:if>
              </div>
              
              
              <div class="card-footer">
              <c:if test="${list.gdsStock<10 }">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</small>
                </c:if>
                
                 <c:if test="${list.gdsStock>=10 }">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </c:if>
              </div>
              
              
            </div>
           
          </div>
          
          </c:forEach>
		
                    	

                   		 
                        
                    	
                    	
                    


        </div>
        <!-- /.row -->
        <ul class="pagination justify-content-center">
                    	<c:if test="${page.prev }">
                <li class="page-item">    	<a class="page-link" href="homepage?pageNum=${page.startPage-1 }&keyword=${page.cri.keyword}">previous</a></li>
                    	
                    	</c:if>
                    	
                    	
                   		 <c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
                    
                 <li class="page-item">    	<a class="page-link" href="homepage?pageNum=${num }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num }</a></li> 
                   		 </c:forEach>	
                   		 
                   		 <c:if test="${page.next }">
                  <li class="page-item"> <a class="page-link" href="homepage?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Next </a></li>
                    	
                    	</c:if>
                    	
           </ul>


      
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
   <%@ include file="./include/footer.jsp" %>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="./resources/vendor/jquery/jquery.min.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 

</body>

</html>

