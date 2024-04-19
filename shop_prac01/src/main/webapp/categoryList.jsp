<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>categoryList</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.content-table {
		padding-top: 100px;
	}
	.list_button {
		text-align: right;
		padding-bottom: 20px;
		display: inline-block;
	}

</style>
<script type="text/javascript">
  function deleteFn(empNo){
	  location.href="/shop_prac01/empDelete.do?empNo="+empNo;
  }
</script>
</head>
<body>
<div class="row">
<div class="col-2"></div>
<div class="col-8 content-table">
	<c:set var="empId" value="${seessionScope.loginEmp.empId}" />
	<c:if test="${empId!=null && empId!=''}">
	<span class="list_button"><input type="button" value="로그아웃" class="btn btn-primary" onclick="location.href='/shop_prac01/empLogout.do'"/></span>
	</c:if>
	<c:if test="${empId==null || empId==''}">
	<span class="list_button"><input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='/shop_prac01/empForm.jsp'"/></span>
	</c:if>
	<table class="table table-hover">
	<thead class="table-dark">
	  <tr>
	    <th>카테고리번호</th>
	    <th>카테고리명</th>
	    <th>생성날짜</th>
	    <th>업데이트날짜</th>
	    <th>삭제</th>
	  </tr>
	</thead>
	<tbody>
	<c:forEach var="vo" items="${categoryList}">
	  <tr>
	    <td>${vo.categoryNo}</td>
	    <td>${vo.categoryName}</td>
	    <td>${vo.createDate}</td>
	    <td>${vo.updateDate}</td>
	    <c:if test="${vo.active eq 'ON'}">
	    	
	    <td><input type="button" value="삭제" class="btn btn-warning" onclick="deleteFn(${vo.empNo})"></td>
	  </tr>
	</c:forEach>
	</tbody>
	</table>
</div>
<div class="col-2"></div>
</div>
</body>
</html>