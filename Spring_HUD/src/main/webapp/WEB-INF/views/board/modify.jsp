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
<style >
.container table tr td img{width:200px;height:200px; }
.container{margin-top: 20px; margin-bottom: 20;}
</style>
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



		

<form action="modify" method="post">
<table  class="table table-bordered">
<tbody>

<tr>
<td>번호</td><td><input type="text" name="no" value="${modify.no}" readonly="readonly"class="form-control" ></td>
</tr>
<tr>
<td>제목</td>
<td>

<select name="subject" class="form-control">
				<option value="${modify.subject}">${modify.subject}</option>
                <option value="[상품문의]">[상품문의]</option>
                <option value="[배송문의]">[배송문의]</option>
                <option value="[환불문의]">[환불문의]</option>
                <option value="[입금문의]">[입금문의]</option>
                <option value="[기타문의]">[기타문의]</option>
                </select>
</td>
</tr>
<tr>
<td>이미지</td><td><img src="../resources/imgUpload/${modify.img}"></td>
</tr>
<tr>
<td>내용</td><td><textarea  name="content" class="form-control">${modify.content}></textarea></td>
</tr>
<tr> 

<td>작성자</td><td>${modify.writer}</td>
</tr>
<tr>
<td>작성일자</td><td>${modify.write_date}</td>
</tr>
<tr>
<td>조회수</td><td>${modify.cnt}</td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="수정"  > 
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