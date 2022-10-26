<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Git Test</title>
</head>
<body>
	Git Test <br>
	3조 신발가게 세미 프로젝트 <br>
	
<form action="requestCBCalc.jsp">

	계산을 위한 숫자를 입력하세요.<br>
	숫자 1 : <select name="num1">
	
	<%
		for (int i = 0; i<=100; i++) {
	%>
		<option><%=i%></option>
			
	<%
		}
	%>
	</select><br>
	
	숫자 2 : <select name="num2">
	
	<%
		for (int i = 0; i<=100; i++) {
			out.println("<option>" + i + "</option>");
			
		}
	%>
	</select>
	<br>
	
	계산방법 : <br>
	  <input type="checkbox" name="calc" value="덧셈" checked="checked">덧셈 <br>
	  <input type="checkbox" name="calc" value="뺄셈">뺄셈 <br>
	  <input type="checkbox" name="calc" value="곱셈">곱셈 <br>
	  <input type="checkbox" name="calc" value="나눗셈">나눗셈 <br>
	  
	  <input type="submit" value="계산">
	
</form>
</body>
</html>