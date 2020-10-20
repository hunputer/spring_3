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

<style type="text/css">

	.c1{
	 cursor: pointer;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>Notice List</h3>
  <div class="row">
  <div class="col-sm-5">
  <form id="searchForm" action="./noticeList">
  	<input type="hidden" name="curPage" id="curPage">
       <div class="input-group">
        <select class="input-group-sm" id="kind" name="kind">
        	<option value="tt">Title</option>
        	<option value="wr">Writer</option>
        	<option value="con">Contents</option>
        </select>
        <input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
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
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	
  	<c:forEach items="${lists}" var="dto">
  		<tr>
  			<td>${dto.num}</td>
  			<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
  			<td>${dto.writer}</td>
  			<td>${dto.regDate}</td>
  			<td>${dto.hit}</td>
  		</tr>
  	</c:forEach>
  </table>
  
  <div>
  	<c:if test="${pager.startNum gt 1}">
  		 <span class="c1" title="${pager.startNum-1}"}>[이전]</span>
    </c:if>
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<span class="c1" title="${i}">${i}</span>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  		<span class="c1" title="${pager.lastNum+1}">[다음]</span>
  	</c:if>
  </div>
  
  <a href="./noticeWrite">Write</a>
</div>

	<script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind == ''){
			kind = "tt";
		}
		var search = '${pager.search}';
		$("#kind").val(kind);
		$("#search").val(search);
		
		$(".c1").click(function(){
			var cur = $(this).attr("title");
			$("#curPage").val(cur);
			$("#kind").val(kind);
			$("#search").val(search);
			$("#searchForm").submit();
		})
	</script>

</body>
</html>