<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup AHNSUBIN</title>
</head>

<body>
<div style="text-align: center;">
<br><br>
	&nbsp;&nbsp;&nbsp;<h2>회원가입</h2>&nbsp;&nbsp;&nbsp;
</div>
<form action="signup.do" method="post" >
	<table style="margin-left: auto; margin-right: auto;">
	   <tr>
	      <td>아이디</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cId" size="40"></td>
	   </tr>
	   <tr>
	      <td>비밀번호</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cPw" size="40"></td>
	   </tr>
	   <tr>
	      <td>비밀번호 재확인</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cPw1" size="40"></td>
	   </tr>
	   <tr>
	      <td>이름</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cName" size="40"></td>
	   </tr>
	   <tr>
	      <td>휴대전화</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cTelno" size="40"></td>
	   </tr>
	   <tr>
	      <td>이메일</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cEmail" size="40"></td>
	   </tr>
	   <tr>
	      <td>주소</td>
	   </tr>
	   <tr>
	      <td><input type="text" name="cAddress" size="40"></td>
	   </tr>
	   <tr>
	      <td><input type="submit" value="회원가입하기" style="WIDTH: 210pt; HEIGHT: 20pt"><a href="home.jsp">홈으로 돌아가기</a></td>
	   </tr>
	</table>
	</form>
</body>
</html>