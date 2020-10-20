<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="./notice/noticeList">Notice</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <h3>Notice Select Page</h3>
  <h3 id="num">${dto.num}</h3>
  <h1>Title : ${dto.title}</h1>
  <h1>Writer : ${dto.writer}</h1>
  <h1>Contents : ${dto.contents}</h1>
  <input type="button" title="${dto.num}" value="Delete" id="del" class="btn btn-warning">
  <input type="button" title="${dto.num}" value="Update" id="update" class="btn btn-warning">
</div>

<script type="text/javascript">
	$("#del").click(function(){
		var num = $("#del").attr("title");
		alert(num);
		location.href="./noticeDelete?num="+num;
	});
	
	$("#update").click(function(){
		var num = $("#del").attr("title");
		alert(num);
		location.href="./noticeUpdate?num="+num;
	});
</script>

</body>
</html>