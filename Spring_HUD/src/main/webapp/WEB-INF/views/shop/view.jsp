




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
 <!-- Bootstrap core CSS -->
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../resources/css/shop-homepage.css" rel="stylesheet">
   <link href="../resources/css/shop-homepage2.css" rel="stylesheet">

  <script> 
 function replyList(){ 
  
 var gdsNum = ${view.gdsNum};
 $.getJSON("/hud/shop/view/replyList" + "?n=" + gdsNum, function(data){	//비동기식으로 제이슨데이터를 가져옴
  var str = "";
  
  $(data).each(function(){
   
   console.log(data);
   
   var repDate = new Date(this.repDate);
   repDate = repDate.toLocaleDateString("ko-US")
   
   str += "<li data-gdsNum='" + this.gdsNum + "'>"
     + "<div class='userInfo'>"
     + "<span class='email'>" + this.email + "</span>"
     + "<span class='date'>" + repDate + "</span>"
     + "</div>"
     + "<div class='replyContent'>" + this.repCon + "</div>"
     
     + "<c:if test='${member != null}'>"  //로그인상태라면 수정삭제를 출력하고 아니면 안보이게함
     
     + "<div class='replyFooter'>"
     + "<button type='button' class='modify' data-repNum='" + this.repNum + "'>수정</button>"
     + "<button type='button' class='delete' data-repNum='" + this.repNum + "'>삭제</button>"
     + "</div>"
     
     + "</c:if>"
     
     + "</li>";           
  });
  
  $("section.replyList ol").html(str);
 });
 
 }
</script>



<script>
$(document).on("click", ".modify", function(){
	 //$(".replyModal").attr("style", "display:block;");
	 $(".replyModal").fadeIn(200);
	 
	 var repNum = $(this).attr("data-repNum");
	 var repCon = $(this).parent().parent().children(".replyContent").text();
	 
	 $(".modal_repCon").val(repCon);
	 $(".modal_modify_btn").attr("data-repNum", repNum);
	 
	});
</script>







<style>
 div.goods div.goodsImg { float:left; width:350px; }
 div.goods div.goodsImg img { width:350px; height:auto; }
 
 div.goods div.goodsInfo { float:right; width:330px; font-size:22px; }
 div.goods div.goodsInfo p { margin:0 0 20px 0; }
 div.goods div.goodsInfo p span { display:inline-block; width:100px; margin-right:15px; }
 
 div.goods div.goodsInfo p.cartStock input { font-size:22px; width:50px; padding:5px; margin:0; border:1px solid #eee; }
 div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:none; }
 div.goods div.goodsInfo p.addToCart { text-align:right; }
 div.goods div.gdsDes { font-size:18px; clear:both; padding-top:30px; }
</style>

<style>
 section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.replyList { padding:30px 0; }
 section.replyList ol { padding:0; margin:0; }
 section.replyList ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.replyList div.userInfo { }
 section.replyList div.userInfo .email { font-size:24px; font-weight:bold; }
 section.replyList div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.replyList div.replyContent { padding:10px; margin:20px 0; }
 section.replyList div.replyFooter button { font-size:14px; border: 1px solid #999; background:none; margin-right:10px; }
</style>

<style>
 div.replyModal { position:relative; z-index:1;display:none; }
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }
</style>



  

 
<style>
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
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
		<br>
		 <div class="row">
		 
			<section id=content>
			<form role="form" method="post">
 <input type="hidden" name="gdsNum" value="${view.gdsNum}" />
</form>

<table border="1">
<tr>
<td>
<div class="goods">
 <div class="goodsImg">
  <img src="../resources/imgUpload/${view.gdsImg}">
 </div>
 
 <div class="goodsInfo">
  <p class="gdsName"><span>상품명</span>${view.gdsName}</p>
  
  <p class="cateName"><span>카테고리</span>${view.cateName}</p>
  
  <p class="gdsPrice">
   <span>가격 </span><fmt:formatNumber pattern="###,###,###" value="${view.gdsPrice}" /> 원
  </p>
  

  
  <p class="gdsStock">
   <span>재고 </span><fmt:formatNumber pattern="###,###,###" value="${view.gdsStock}" /> EA
  </p>
  
    <c:if test="${view.gdsStock !=0 }">
  
 <p class="cartStock">
 <span>구입 수량</span>
  <button type="button" class="minus">-</button>
 
 <input type="number" class="numBox" min="1" max="${view.gdsStock}" value="1" readonly="readonly"/>
 <button type="button" class="plus">+</button>
 
 <script>
  $(".plus").click(function(){
   var num = $(".numBox").val();
   var plusNum = Number(num) + 1;
   
   if(plusNum > ${view.gdsStock}) {
    $(".numBox").val(num);
   } else {
    $(".numBox").val(plusNum);          
   }
  });
  
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   
   if(minusNum <= 0) {
    $(".numBox").val(num);
   } else {
    $(".numBox").val(minusNum);          
   }
  });
 </script>
 
</p>
  
  <p class="addToCart">
  <c:if test="${view.gdsStock>0 }">
 <button type="button" class="addCart_btn">카트에 담기</button>
 </c:if>
 <c:if test="${view.gdsStock<=0 }">
	<p>상품수량이 부족합니다.</p>
</c:if>
 
 
 <script>
 $(".addCart_btn").click(function(){
  var gdsNum = $("#gdsNum").val();
  var cartStock = $(".numBox").val();
           
  var data = {
    gdsNum : gdsNum,
    cartStock : cartStock
    };
  
  $.ajax({
   url : "/hud/shop/view/addCart",
   type : "post",
   data : data,
   success : function(result){
    
    if(result == 1) {
     alert("카트 담기 성공");
     $(".numBox").val("1");
    } else {
     alert("회원만 사용할 수 있습니다.")
     $(".numBox").val("1");
    }
   },
   error : function(){
    alert("카트 담기 실패");
   }
  });
 });
</script>
</p>
</c:if>



 </div>
 
 <div class="gdsDes">${view.gdsDes}</div>
</div>	
</td>
</tr>

	</table>		
	<div id="reply">

 <c:if test="${member == null }">
  <p>소감을 남기시려면 <a href="/hud/member/login_form.do">로그인</a>해주세요</p>
 </c:if>
 
 <c:if test="${member != null}">
 <section class="replyForm">
  <form role="form" method="post" autocomplete="off">
  
  <input type="hidden" name="gdsNum" id="gdsNum" value="${view.gdsNum}">
   <div class="input_area">
    <textarea name="repCon" id="repCon"></textarea>
   </div>
   
   <div class="input_area">
   <!--  <button type="submit" id="reply_btn">소감 남기기</button> -->
     <button type="button" id="reply_btn">상품 후기남기기</button>
    <script>
 $("#reply_btn").click(function(){
  
  var formObj = $(".replyForm form[role='form']");
  var gdsNum = $("#gdsNum").val();
  var repCon = $("#repCon").val()
  
  var data = {
    gdsNum : gdsNum,
    repCon : repCon
    };
  
  $.ajax({
   	url : "/hud/shop/view/registReply",
   	type : "post",
   	data : data,
   	success : function(date){
   		
    replyList();
    $("#repCon").val("");
   }
  });
 });
</script>
   </div>
   
  </form>
  
 </section>
 
 </c:if>
 
 <section class="replyList">
 <ol>
 <%-- <c:forEach items="${reply}" var="reply">

  <li>
      <div class="userInfo">
       <span class="email">${reply.email}</span>
       <span class="date"><fmt:formatDate value="${reply.repDate}" pattern="yyyy-MM-dd" /></span>
      </div>
      <div class="replyContent">${reply.repCon}</div>
    </li>
   </c:forEach> --%>
  </ol>
  	<script>
  	 replyList();
  	</script>
  	<script>
  	$(document).on("click", ".modify", function(){
 	$(".replyModal").attr("style", "display:block;");
});
  	</script>
	<script>
 $(document).on("click", ".delete", function(){
	 var deletConfirm=confirm("댓글을정말로삭제하시겠습니까?");
	 
	 if(deletConfirm){
		 var data={repNum:$(this).attr("data-repNum")
	 }
  
  var data = {repNum : $(this).attr("data-repNum")};
   
  $.ajax({
   url : "/hud/shop/view/deleteReply",
   type : "post",
   data : data,
   success : function(result){
	   
	   if(result == 1) {
	    replyList();
	   } else {
	    alert("작성자 본인만 할 수 있습니다.");     
	   }
	  },
	  error:function(){
		  alert("로그인을하셔야합니다.")
	  }
  	});
   }
 });
</script>
      
</section>
</div>	
			
			
			
			
			
			
			
			
			
			
			</section>
		
		
			
		</div>		
	</section>
		
</div>

<div class="replyModal">

 <div class="modalContent">
  
  <div>
   <textarea class="modal_repCon" name="modal_repCon"></textarea>
  </div>
  
  <div>
   <button type="button" class="modal_modify_btn">수정</button><script>
$(".modal_modify_btn").click(function(){
 var modifyConfirm = confirm("정말로 수정하시겠습니까?");
 
 if(modifyConfirm) {
  var data = {
     repNum : $(this).attr("data-repNum"),
     repCon : $(".modal_repCon").val()
    };  // GoodsReplyVo 형태로 데이터 생성
  
  $.ajax({
   url : "/hud/shop/view/modifyReply",
   type : "post",
   data : data,
   success : function(result){
    
	 //result의값에 따라 동작
    if(result == 1) {
     replyList(); //리스트 새로고침
     $(".replyModal").fadeOut(200);
    } else {
     alert("작성자 본인만 할 수 있습니다.");   //본인아닌경우    
    }
   },
   error : function(){//비로그인시 에러발생
    alert("로그인하셔야합니다.")
   }
  });
 }

});
</script>
   <button type="button" class="modal_cancel">취소</button>
   <script>
$(".modal_cancel").click(function(){
 $(".replyModal").attr("style", "display:none;");
});
</script>
  </div>
  
 </div>

 <div class="modalBackground"></div>
 
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

































