<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
  
<div class="container">
  <h3>qna Select page</h3>
  <h3 id="num">${dto.num}</h3>
  <h1>Title : ${dto.title}</h1>
  <h1>Writer : ${dto.writer}</h1>
  <h1>Contents : ${dto.contents}</h1>
  <input type="button" title="${dto.num}" value="Delete" id="del" class="btn btn-warning">
  <input type="button" title="${dto.num}" value="Update" id="update" class="btn btn-warning">
  <a href="./qnaReply?num=${dto.num}" class="btn btn-info">Reply</a>
</div>

<script type="text/javascript">
	$("#del").click(function(){
		var num = $("#del").attr("title");
		alert(num);
		location.href="./qnaDelete?num="+num;
	});
	
	$("#update").click(function(){
		var num = $("#del").attr("title");
		alert(num);
		location.href="./qnaUpdate?num="+num;
	});
</script>

</body>
</html>