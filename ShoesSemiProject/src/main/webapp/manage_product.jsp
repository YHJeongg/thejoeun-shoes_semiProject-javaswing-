<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정 및 삭제</title>
</head>
<body>
<div align="center">
	<h1>제품 수정 및 삭제</h1>
	<table border="1">
		<tr>
			<th>제품 번호</th><th>주문번호</th><th>브랜드명</th><th>제품명</th><th>가격</th><th>카테고리</th><th>사이즈</th>
			<th>재고 수정 날짜</th><th>남은 수량</th><th>이미지</th><th>제품 상세정보</th><th>삭제</th>
		</tr>
		<c:forEach items="${manage_product}" var="dto"><!-- 이페이지의 각각의 속성들을 dto로 보내서 보려는 기능을 사용하려고 dto선언 -->
			<tr>
				<td>${dto.pId}</td>
				<td>${dto.take_tOrderid}</td>
				<td><a href="content_view.do?bId=${dto.bId}">${dto.pBrand}</a></td>
				<td>${dto.pName}</td>
				<td>${dto.pPrice}</td>
				<td>${dto.pCategory}</td>
				<td>${dto.pSize}</td>
				<td>${dto.pStokedate}</td>
				<td>${dto.pStock}</td>
				<td>${dto.pImage}</td>
				<td>${dto.pInformation}</td>
				<td><a href="delete.do?bId=${dto.bId}">삭제</a></td>
			</tr>
		
		</c:forEach>
		<tr>
			<td colspan="9"><a href="write_view.do">제품 넣기</a></td>
		</tr>
	</table>
</div>
</body>
</html>