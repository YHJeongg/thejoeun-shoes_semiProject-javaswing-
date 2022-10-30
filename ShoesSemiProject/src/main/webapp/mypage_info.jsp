<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>
<body>
	<div align="center">
		<h1>내 정보</h1>
		
		<form action="">
		<table>
		<tr><td> ID :</td> <td>TEST<br></td></tr> 
		<tr><td> 현재 비밀번호 :</td> <td>TEST<br></td></tr> 
		<tr><td> 새 비밀번호 :</td> <td>TEST<br></td></tr> 
		<tr><td> 새 비밀번호 확인 : &nbsp;</td> <td>TEST<br></td></tr> 
		<tr><td> 이름 :</td> <td>TEST<br></td></tr> 
		<tr><td> 전화번호 :</td> <td>TEST<br></td></tr> 
		<tr><td> 이메일 :</td> <td>TEST<br></td></tr> 
		<tr><td> 주소 :</td> <td>TEST<br><br></td></tr>
		<tr><td></td><td><input type="submit" value="수정" onclick="javascript: form.action='mypage_modify.do'">
		<input type="submit" value="탈퇴" onclick="javascript: form.action='mypage_delete.jsp'"></td></tr>
	
		</table>
		</form>
			
	</div>

</body>
</html>