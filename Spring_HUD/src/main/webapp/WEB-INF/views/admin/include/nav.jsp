<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${member !=null }">
	<input type="button" value="로그아웃" onclick="location.href='/hud/member/logout.do'">
	
	<li>
			<a href="/hud/homepage">일반화면</a>
		</li>
</c:if>
</body>
</html>