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
  <h3>Member List</h3>
  <div class="row">
  <div class="col-sm-5">
  <form action="./memberList">
       <div class="input-group">
        <select class="input-group-sm" id="sel1" name="kind">
        	<option value="tt">Id</option>
        	<option value="name">Name</option>
        	<option value="email">Email</option>
        </select>
        <input id="msg" type="text" class="form-control" name="search" placeholder="Additional Info">
        <div class="input-group-btn">
              <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
              </button>
        </div>
      </div>
      
  </form>
  </div>
  </div>
  
  <table class="table table-hover">
  	<tr>
  		<td>num</td>
  		<td>id</td>
  		<td>pw</td>
  		<td>name</td>
  		<td>email</td>
  	</tr>
  	
  	<c:forEach items="${lists}" var="dto">
  		<tr>
  			<td>${dto.num}</td>
  			<td><a href="./memberSelect?num=${dto.num}">${dto.id}</a></td>
  			<td>${dto.pw}</td>
  			<td>${dto.name}</td>
  			<td>${dto.email}</td>
  		</tr>
  	</c:forEach>
  </table>
  
  <div>
  	<c:if test="${pager.startNum gt 1}">
  		<a href="./memberList?curPage=${pager.startNum-5}">[이전]</a>
  	</c:if>
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<a href="./memberList?curPage=${i}">${i}</a>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  		<a href="./memberList?curPage=${pager.lastNum+1}">[다음]</a>
  	</c:if>
  </div>
  
  <a href="./member/memberJoin">Join</a>
</div>

</body>
</html>