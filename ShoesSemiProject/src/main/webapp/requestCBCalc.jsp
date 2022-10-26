<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Arrays" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String[] calc = request.getParameterValues("calc");
double num1 = 0;
double num2 = 0;
num1 = Double.parseDouble(request.getParameter("num1"));
num2 = Double.parseDouble(request.getParameter("num2"));

%>

	<%=Arrays.toString(calc) %> <br>

<%
String str = Arrays.toString(calc);

List<String> calcList = Arrays.asList(calc);

	if (calcList.contains("덧셈")) {
		out.println("덧셈 결과는 " + (num1+num2) + "입니다.<br>");
	}
	if (str.contains("뺄셈")) {
		out.println("뺄셈 결과는 " + (num1-num2) + "입니다.<br>");
	}
	if (str.contains("곱셈")) {
		out.println("곱셈 결과는 " + (num1*num2) + "입니다.<br>");
	}
	if (str.contains("나눗셈")) {
		out.println("나눗셈 결과는 " + (num1/num2) + "입니다.<br>");
	}
%>

</body>
</html>