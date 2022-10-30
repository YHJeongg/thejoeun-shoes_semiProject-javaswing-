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
		<tr><td> ID :</td> <td><input type="text" size="10" name="cId" value="${mypage_view.cId}" readonly="readonly" ><br></td></tr> 
		<tr><td> 현재 비밀번호 :</td> <td><input type="text" size="12" name="curpw" placeholder="현재 비밀번호"><br></td></tr> 
		<tr><td> 새 비밀번호 :</td> <td><input type="text" size="12" name="newpw1" placeholder="새 비밀번호"><br></td></tr> 
		<tr><td> 새 비밀번호 확인 :</td> <td><input type="text" size="12" name="newpw2" placeholder="새 비밀번호"><br></td></tr> 
		<tr><td> 이름 :</td> <td><input type="text" size="10" name="cName" value="${mypage_view.cName}"><br></td></tr> 
		<tr><td> 전화번호 :</td> <td><input type="text" size="10" name="cTelno" value="${mypage_view.cTelno}"><br></td></tr> 
		<tr><td> 이메일 :</td> <td><input type="text" size="10" name="cEmail" value="${mypage_view.cEmail}"><br></td></tr> 
		<tr><td> 주소 :</td> <td><input type="text" size="10" name="cAddress" value="${mypage_view.cAddress}"><br><br></td></tr>
		<tr><td></td><td><input type="submit" value="수정" onclick="javascript: form.action='mypage_modify.do'">
		<input type="submit" value="탈퇴" onclick="javascript: form.action='mypage_delete.do'"></td></tr>
	
		</table>
		</form>
			
	</div>

</body>
</html>