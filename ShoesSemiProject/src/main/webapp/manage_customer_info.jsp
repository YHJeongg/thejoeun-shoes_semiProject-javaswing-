<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${manage_customer_info.cId}님의 정보 조회</title>
</head>
<body>

<div align="center">
	<h2>${manage_customer_info.cId}님의 정보 조회</h2>
	<br><br><br>
	<form action="manage_product.do" method="post">
	<input type="hidden" name="cId" value="${manage_customer_info.cId}">
		<table border="0">
			<tr>
				<td>회원 ID : </td>
				<td>${manage_customer_info.cId}</td>
			</tr>
			<tr>
				<td>회원 PW : </td>
				<td>${manage_customer_info.cPw}</td>
			</tr>
			<tr>
				<td>회원 이름 : </td>
				<td>${manage_customer_info.cName}</td>
			</tr>
			<tr>
				<td>회원 전화번호 : </td>
				<td>${manage_customer_info.cTelno}</td>
			</tr>
			<tr>
				<td>회원 이메일 : </td>
				<td>${manage_customer_info.cEmail}</td>
			</tr>
			<tr>
				<td>회원 주소 : </td>
				<td>${manage_customer_info.cAddress}</td>
			</tr>
			<tr>
				<td>회원 가입 날짜 : </td>
				<td>${manage_customer_info.cIndate}</td>
			</tr>
			<tr>
				<td>회원 탈퇴 날짜 : </td>
				<td>${manage_customer_info.cOutdate}</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit"value="확인"></td>
			</tr>	
			
		
		</table>
	</form>
</div>



</body>
</html>