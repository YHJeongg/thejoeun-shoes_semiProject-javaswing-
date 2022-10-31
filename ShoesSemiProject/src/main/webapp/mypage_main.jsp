<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
	<div align="center">
		<h1>My Page</h1>
		ID : ${cId}
		<br><br>
		<form action="">
		<input type="submit" value="주문내역" onclick="javascript: form.action='orderlist.jsp'" style="width: 100pt; height: 30pt">
		<input type="submit" value="내 정보" onclick="javascript: form.action='mypage_infoselect.do'" style="width: 100pt; height: 30pt">
		</form>
		
	</div>
</body>
</html>