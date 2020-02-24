<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript"src="../resources/js/button.js"></script>
 <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage2.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style >
.container{margin-top: 20px; margin-bottom: 20;}

.container table tr td img{width:200px;height:200px; }

 div.replyModal { position:relative; z-index:1; display: none; }
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:180px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }

</style>
<style>
 section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.readReply { padding:30px 0; }
 section.readReply ol { padding:0; margin:0; }
 section.readReply ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.readReply div.userInfo { }
 section.readReply div.userInfo .writer { font-size:18px; font-weight:bold; }
 section.readReply div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.readReply div.replyContent { padding:10px; margin:20px 0; }
</style>

	<script> 
	
function readReply(){
 var no = ${detail.no};
 $.getJSON("/hud/board/detail/readReply" + "?n=" + no, function(data){
  var str = "";
  var mid = "${member.id}";
  $(data).each(function(){
   
   console.log(data);
   
   var regDate = new Date(this.regDate);
   regDate = regDate.toLocaleDateString("ko-US")
   
   str += "<li data-rno='" + this.rno + "'>"
     + "<div class='userInfo'>"
     + "<span class='writer'>" +"작성자 :" +this.writer + "</span>"
     + "<span class='date'>" + regDate + "</span>"
     + "</div>"
     + "<div class='replyContent'>" +"내용 :"+ this.content + "</div>";
     
   
     if(mid == this.writer){
    	  str += "<div class='replyFooter'>"
    	     + "<button type='button' class='modify' data-rno='" + this.rno + "'>수정</button>"
    	     + "<button type='button' class='delete' data-rno='" + this.rno + "'>삭제</button>"
    	     + "</div>";
     } else{
    	 
     }
     
      
     
     + "</li>";           
  });
  
  $("section.readReply ol").html(str);
 });
 
}
</script>


</head>



<body>

<header id="header_box">
		<div id="header_box">
		<%@ include file="../include/header.jsp" %>
		</div>
	</header>	
	
	<nav id="nav">
		<div id="nav_box">
			
		</div>	
	</nav>
<div class="container">

<table class="table table-bordered">
   <thead>
        <caption> 게시글 상세보기 </caption>
   </thead>
    
    <tbody>
       		 <tr>
                <th>번호: </th>
                <td>${detail.no}</td>
            </tr>  
            <tr>
                <th>제목: </th>
                <td>${detail.subject}</td>
            </tr>
            <tr>
                <th>내용: </th>
                <td>${detail.content}</td>
            </tr>  <tr>
                <th>이미지: </th>
                <td>
                <c:if test="${detail.img!=null }">
                <img src="../resources/imgUpload/${detail.img}">
                </c:if>
                </td>
            </tr>
            <tr>
                <th>작성자: </th>
                <td>${detail.writer}</td>
            </tr>  
             <tr>
                <th>작성일자: </th>
                <td>${detail.write_date}</td>
            </tr>  
             <tr>
                <th>조회수: </th>
                <td>${detail.cnt}</td>
            </tr>             
            <tr>
<c:if test="${detail.writer==member.id||member.hos==1 }">
<td colspan="2">

<a href="modify?no=${detail.no }">수정</a>
<a href="delete?no=${detail.no }">삭제</a>


</td>
</c:if>
</tr>
       
    </tbody>
</table>

<div>
<section class="readReply">
	<ol>
<%-- 	<c:forEach items="${repList }" var="repList">
	<li>
		<p>작성자:${repList.writer }</p>
		<p>	작성 날짜:${repList.regDate } 	</p>
		<p> ${repList.content }</p>
		
	
	</li>
	
	</c:forEach> --%>
	
	</ol>
	
	<script>
	readReply();
	</script>
	
	
	
	
	<script>
	$(document).on("click", ".modify", function(){
		 $(".replyModal").attr("style", "display:block;");
		});	
	
	
	
 $(document).on("click", ".delete", function(){
  
  var deletConfirm=confirm("정말로 삭제하시겠습니까?");
  if(deletConfirm){
  var data = {rno : $(this).attr("data-rno")};
   
  $.ajax({
   url : "/hud/board/detail/deleteReply",
   type : "post",
   data : data,
   success : function(result){
	   if(result ==1){
	   readReply();
	   }else{
		   alert("작성자 본인만 사용할수있습니다.")
	   }
   }
  });
  }
 });
</script>
	
	
</section>	
	
	

	
	
	
	
	<c:if test="${member.id==null}">
	댓글을 작성하시려면 <a href="../member/login_form.do">로그인</a>을 해주세요
	</c:if>
	<c:if test="${member.id!=null}">
	
	<section class="replyForm">
<form role="form" method="post" autocomplete="off">

 <input type="hidden" id="no" name="no" value="${detail.no}" readonly="readonly" />


<p class="userName"><label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" readonly="readonly" value="${member.id}" />
 <p><label for="content">댓글 내용</label><textarea id="content" name="content"></textarea></p>
 
  <button type="button" id="reply_btn2">작성</button>
  
  <script>
 $("#reply_btn2").click(function(){
  
  var formObj = $(".replyForm form[role='form']");
  var no = $("#no").val();
  var content = $("#content").val()
  
  var data = {
    no : no,
    content : content
    };
  
  $.ajax({
   url : "/hud/board/detail/replyWrite",
   type : "post",
   data : data,
   
   
   success : function(){
	   readReply();
	   $("#content").val("");
   }
  });
 });
</script>
 
</form>
</section>
</c:if>
	

</div>


</div>






<div class="replyModal">

 <div class="modalContent">
  
  <div>
   <textarea class="modal_content" name="modal_content"></textarea>
  </div>
  
  <div>
   <button type="button" class="modal_modify_btn">수정</button>
   <button type="button" class="modal_cancel">취소</button>
  </div>
  
 </div>

 <div class="modalBackground"></div>
 
</div>
<script>
$(document).on("click", ".modify", function(){
	 //$(".replyModal").attr("style", "display:block;");
	 $(".replyModal").fadeIn(200);
	 
	 var rno = $(this).attr("data-rno");
	 var content = $(this).parent().parent().children(".replyContent").text();
	 
	 $(".modal_content").val(content);
	
	 $(".modal_modify_btn").attr("data-rno", rno);
	 
	 
	});
</script>
<script>
$(".modal_modify_btn").click(function(){
 var modifyConfirm = confirm("정말로 수정하시겠습니까?");
 
 if(modifyConfirm) {
  var data = {
     rno : $(this).attr("data-rno"),
     content : $(".modal_content").val()
     
    };  // ReplyVO 형태로 데이터 생성
  
  $.ajax({
   url : "/hud/board/detail/modifyReply",
   type : "post",
   data : data,
   success : function(result){
    
    if(result == 1) {
    	readReply();
     $(".replyModal").fadeOut(200);
    } else {
     alert("작성자 본인만 할 수 있습니다.");       
    }
   },
   error : function(){
    alert("로그인하셔야합니다.")
   }
  });
 }
 
});

</script>
<script>
$(".modal_cancel").click(function(){
 $(".replyModal").attr("style", "display:none;");
});
</script>
<footer class="py-5 bg-dark">
   <%@ include file="../include/footer.jsp" %>
    <!-- /.container -->
  </footer>
</body>



</html>