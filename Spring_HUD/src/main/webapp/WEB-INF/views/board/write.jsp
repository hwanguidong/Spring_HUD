<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/plugins/jQuery/jquery-3.4.1.min.js"></script>
<script src="../resources/js/uploadwrite.js"></script>
<link rel="stylesheet" href="../resources/css/upload.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/shop-homepage2.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>

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
<form action="register" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
  
    
    <tbody>
       
            <tr>
                <th>제목: </th>
                <td>
                
                <select name="subject" class="form-control">
                <option value="[상품문의]">[상품문의]</option>
                <option value="[배송문의]">[배송문의]</option>
                <option value="[환불문의]">[환불문의]</option>
                <option value="[입금문의]">[입금문의]</option>
                <option value="[기타문의]">[기타문의]</option>
                </select>
                </td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>작성자: </th>
                <td><input type="text" name="writer" value="${member.id }" readonly="readonly"></td>
            </tr>             
             <tr>
             	<th>파일:</th>
             	<td><input type="file" name="file" id="Img">
             	<div class="select_img"><img src="" /></div>
             	
             	<script>
  $("#Img").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
 </script>
 <%=request.getRealPath("/") %>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="글쓰기">
                    
                </td>
            </tr>
       
    </tbody>
</table>
 </form>
</div>

<footer class="py-5 bg-dark">
   <%@ include file="../include/footer.jsp" %>
    <!-- /.container -->
  </footer>
	






</html>