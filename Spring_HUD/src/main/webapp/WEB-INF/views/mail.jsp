<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>메일보내기</h4>
<form action="mail" method="post">
받는사람:<input type="text" name="to" >
제목:<input type="text" name="title">
내용:<textarea name="content"></textarea>
보내는사람:<input type="text" name="from">
<input type="submit" value="이메일보내기">
</form>
</body>
</html>