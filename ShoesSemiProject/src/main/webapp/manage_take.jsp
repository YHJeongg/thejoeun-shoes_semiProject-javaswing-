<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Line Board</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<br>
		<br>	
		<h1 align="center">Order Product from manufacturer</h1>
		<br>
		<br>
<%
	String queryName = request.getParameter("query");
	String queryContent = request.getParameter("content");
	
	if(queryName == null){
		queryName = "name";
		queryContent = "";
	}
%>
	<form action="take.do">
		<div align="center">
		검색 선택 : 
			<select name="query">
				<option value="brand">브랜드</option>
				<option value="name" selected="selected">상품명</option>
				<option value="size">사이즈</option>
			</select>&nbsp;&nbsp;&nbsp; <!-- &nbsp;는 띄어쓰기 -->
			<input type="text" name="content" size="30">
			<input type="submit" value="검색">
		</div>
	</form>
	<br>

	<form action="take.do">
		<table border="1" class="table table-hover table-bordered border-secondary" style="width: 60%; margin: auto;">
			<thead class="table-success">
				<tr style="text-align: center;">
					<th scope="col">등록번호</th><th>브랜드</th><th>상품명</th><th>카테고리</th><th>사이즈</th><th>가격</th><th>수량</th><th>발주</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.mfId}</td>
						<td>${dto.mfBrand}</td>
						<td>${dto.mfProductname}</td>
						<td>${dto.mfCategory}</td>
						<td>${dto.mfSize}</td>
						<td>${dto.mfPrice}</td>
						<td><input type="number" name="tQty">
						<td><input type="submit" value="발주">
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8"><a href="write_view.do">글작성</a></td>
				</tr>
			</tfoot>
		</table>
		</form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>
</html>