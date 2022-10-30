<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login AHNSUBIN</title>
</head>
<%
	request.setCharacterEncoding("utf-8");

    
	
	%>
<body>
<div style="text-align: center;">
<br><br>
	&nbsp;&nbsp;&nbsp;<h2><a href="home.jsp">Hosix Shoes</a></h2>&nbsp;&nbsp;&nbsp;
	<h3>LOGIN</h3>
	<form action="login.do" method="post">
	<table style="margin-left: auto; margin-right: auto;">
	<tr>
	   <td><input type="text" placeholder="Login" size="30" name="cId"></td>
	</tr>
	<tr>
	   <td><input type="text" placeholder="Passwd" size="30" name="cPw"></td>
	</tr>
	<tr>
	   <td></td>
	</tr>
	<tr>
	   <td><input type="submit" value="로그인하기"></td>
	</tr>
	</table>
	</form>
	
</div>
</body>
</html>