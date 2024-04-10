<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<table class="table table-hover">
<thead class="table-dark">
  <tr>
    <th>사원번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>등급</th>
    <th>사원이름</th>
    <th>직업</th>
    <th>고용날짜</th>
    <th>업데이트날짜</th>
    <th>생성날짜</th>
    <th>권한</th>
  </tr>
</thead>
<tbody>
<c:forEach var="vo" items="${empList}">
  <tr>
    <td>${vo.empNo}</td>
    <td>${vo.empId}</td>
    <td>${vo.empPw}</td>
    <td>${vo.grade}</td>
    <td>${vo.empName}</td>
    <td>${vo.empJob}</td>
    <td>${vo.hireDate}</td>
    <td>${vo.updateDate}</td>
    <td>${vo.createDate}</td>
    <td>${vo.active}</td>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>