<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->
    <%@ page import="java.io.File" %>

<!-- 실제로 파일 업로드 하기 위한 클래스 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정 및 삭제</title>
</head>
<body>
<div align="center">
	<h1>제품 수정 및 삭제</h1>
		<form action="manage_product_search.do">
		
		검색 선택:
		<select name="query">
		<option value="pId">제품 번호</option>
		<option value="take_tOrderid">주문번호</option>
		<option value="pBrand">브랜드명</option>
		<option value="pName">제품명</option>
		<option value="pPrice">가격</option>
		<option value="pCategory">카테고리</option>
		<option value="pSize">사이즈</option>
		<option value="pStockdate">재고 수정 날짜</option>
		<option value="pStock">남은 수량</option>

		
		</select>&nbsp;&nbsp;&nbsp;
		<!-- &nbsp;는 띄어쓰기 -->
		<input type="text" name="content" size="30">
		<input type="submit"value="검색">
	</form>
	<table border="1">
		<tr>
			<th>제품 번호</th><th>주문번호</th><th>브랜드명</th><th>제품명</th><th>가격</th><th>카테고리</th><th>사이즈</th>
			<th>재고 수정 날짜</th><th>남은 수량</th><th>이미지</th><th>제품 상세정보</th><th>삭제</th><th>재고요청</th>
		</tr>
		
		<c:forEach items="${manage_product}" var="dto"><!-- 이페이지의 각각의 속성들을 dto로 보내서 보려는 기능을 사용하려고 dto선언 -->
			<tr>
				<td>${dto.pId}</td>
				<td>${dto.take_tOrderid}</td>
				<td>${dto.pBrand}</td>
				<td><a href="product_select.do?pId=${dto.pId}">${dto.pName}</a></td>
				<td>${dto.pPrice}</td>
				<td>${dto.pCategory}</td>
				<td>${dto.pSize}</td>
				<td>${dto.pStockdate}</td>
				<td>${dto.pStock}</td>
				<td><img name="image" src="./images/adidas.스니커즈.가젤.129,000.png" width="100"></td>
				<td>${dto.pInformation}</td>
				<td><a href="HMPproduct_delete.do?pId=${dto.pId}">삭제</a></td>
				<td><a href="HMPInsertCommand.do?pId=${dto.pId}">재고 요청</a></td>
			</tr>
		
		</c:forEach>
		<tr>
			<td colspan="9"><a href="HMPproduct_insert.do">재고 주문 요청</a></td>
		</tr>
		
	</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table border="1">
		<tr>
			<th>제품 번호</th><th>주문번호</th><th>브랜드명</th><th>제품명</th><th>가격</th><th>카테고리</th><th>사이즈</th>
			<th>재고 수정 날짜</th><th>남은 수량</th><th>이미지</th><th>제품 상세정보</th><th>재고요청 삭제</th>
		</tr>
		
		<c:forEach items="${manage_product}" var="dto"><!-- 이페이지의 각각의 속성들을 dto로 보내서 보려는 기능을 사용하려고 dto선언 -->
			<tr>
				<td>${dto.pId}</td>
				<td>${dto.take_tOrderid}</td>
				<td>${dto.pBrand}</td>
				<td><a href="product_select.do?pId=${dto.pId}">${dto.pName}</a></td>
				<td>${dto.pPrice}</td>
				<td>${dto.pCategory}</td>
				<td>${dto.pSize}</td>
				<td>${dto.pStockdate}</td>
				<td>${dto.pStock}</td>
				<td><img name="image" src="./images/adidas.스니커즈.가젤.129,000.png" width="100"></td>
				<td>${dto.pInformation}</td>
				<td><a href="HMPproduct_delete.do?pId=${dto.pId}">삭제</a></td>
			</tr>
		
		</c:forEach>
		<tr>
			<td colspan="9"><a href="HMPproduct_insert.do">재고 주문 요청</a></td>
		</tr>
	</table>
</div>
</body>
</html>