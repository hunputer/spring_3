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
  <h2>Notice Update Form</h2>
  <form action="./memberUpdate" method="post">
    <div class="form-group">
      <label for="title">id:</label>
      <input type="text" id="id" value="${dto.id}" readonly="readonly" placeholder="Enter Id" name="id">
    </div>
    
    <div class="form-group">
      <label for="title">pw:</label>
      <input type="password" id="pw" value="${dto.pw}" placeholder="Enter pw" name="pw">
    </div> 
    
     <div class="form-group">
      <label for="title">name:</label>
      <input type="text" id="name" value="${dto.name}" placeholder="Enter name" name="name">
    </div>
    
    <div class="form-group">
      <label for="title">email:</label>
      <input type="text" id="email" value="${dto.email}" placeholder="Enter name" name="email">
    </div>	
 
 	<input type="hidden" value="${dto.num}" name="num">
    <button type="submit" class="btn btn-default">Update</button>
  </form>
</div>

</body>
</html>