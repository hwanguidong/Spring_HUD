<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="form1" action="uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">
<input type="file" name="file">  <input type="submit">


</form>

<div >
${savedName}



</div>
<iframe name="zeroFrame"></iframe>
<script type="text/javascript">

function addFilePath(msg){
	alert(msg);
	document.getElementById("form1").reset();
}

</script>




</body>
</html>