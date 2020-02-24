


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
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
</style>
<style >
.table-responsive table img{width:100px;height:100px; }

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

     

<div id="container_box">
	

			
		
			
		</div>		
	</section>


      </div>
      <!-- /.col-lg-3 -->
      <div class="col-md-1">
		</div>
		<div class="col-md-8">
		 <div class="row">
      <div id="content">

        
         


        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        
        <div class="container-fluid">

          <!-- Page Heading -->
          <br><br><br>
        
        <a href="/hud/board/list">  <h1 class="h3 mb-2 text-gray-800">문의게시판</h1></a>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
             
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>게시번호</th>
                      <th>이미지</th>
                      <th>제목</th>                     
                      <th>글쓴이</th>
                      <th>작성일자</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
              
                  <tbody>
                  <c:forEach items="${list}" var="board">
                    <tr>
                      <td>${board.no}</td>
                      <td>
                      <c:if test="${board.img!=null }">
                      <a href='detail?no=${board.no }'><img src="../resources/imgUpload/${board.img}">
                      </a>
                      </c:if>
                      </td>
                      <td><a href='detail?no=${board.no }'>${board.subject}</a></td>                      
                      <td>${board.writer}</td>
                      <td>${board.write_date}</td>
                      <td>${board.cnt}</td>
                    </tr>
                   </c:forEach> 
                    <tr>
                   
                    	<td> <c:if test="${member !=null }"><a href="register">글쓰기</a></c:if></td>
                    	
                    	<td colspan="5">
                    	
                    	
                   <ul class="pagination"> 	
                    	<c:if test="${page.prev }">
                   <li class="page-item"><a class="page-link" href="list?pageNum=${page.startPage-1 }&keyword=${page.cri.keyword}">previous</a></li>
                    	
                    	</c:if>
                    	
                    	
                   		 <c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
                    
                    <li class="page-item"><a class="page-link" href="list?pageNum=${num }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num }</a></li> 
                   		 </c:forEach>	
                   		 
                   		 <c:if test="${page.next }">
                    <li class="page-item"><a class="page-link" href="list?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Next 
                    	</a></li>
                    	
                    	</c:if>
                   		 
                     </ul>   
                    	
                    	</td>
                    	
                    
                    
                    </tr>
                    <tr>
                     <form action="list" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
            
            	<input type="hidden" name="pageNum"  value="${page.cri.getPageNum() }">
            	<input type="hidden" name="Amount" value="${page.cri.getAmount() }">
            	
              <input type="text" name="keyword" class="form-control bg-light border-0 small" placeholder="제목/글쓴이" aria-label="Search" aria-describedby="basic-addon2">
              
              
              <div class="input-group-append">
                <input class="btn btn-primary" type="submit" value="검색"> 
              </div>
            </div>
          </form>
                    </tr>
                   
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
</div>
</div>
</div>
</div>
</div>
    
  <!-- /.container -->

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















