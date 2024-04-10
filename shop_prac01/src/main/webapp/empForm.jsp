<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empForm</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="/shop_prac01/empInsert.do" method="post">
<table class="table table-bordered">
  <tr>
    <td>아이디</td>
    <td><input type="text" name="empId"/></td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input type="password" name="empPw"/></td>
  </tr>
  <tr>
    <td>등급</td>
        <td>
    	<input type="radio" name="grade" value="0"/>&nbsp;0
    	<input type="radio" name="grade" value="1"/>&nbsp;1
    </td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input type="text" name="empName"/></td>
  </tr>
  <tr>
    <td>직업</td>
    <td><input type="text" name="empJob"/></td>
  </tr>
  <tr>
    <td>고용날짜</td>
    <td><input type="date" name="hireDate"/></td>
  </tr>
  <tr>
    <td>권한</td>
    <td>
    	<input type="radio" name="active" value="ON"/>&nbsp;ON
    	<input type="radio" name="active" value="OFF"/>&nbsp;OFF
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="가입" class="btn btn-primary"/>
      <input type="reset" value="취소" class="btn btn-warning"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>