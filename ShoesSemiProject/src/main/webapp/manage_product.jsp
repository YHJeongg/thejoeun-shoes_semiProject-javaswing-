<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->

<!-- 실제로 파일 업로드 하기 위한 클래스 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 상품 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">

<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">

<!-- Slick -->
<link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">

</head>
<body>

	<%@include file="header_manage.jsp"%><!-- 부트스트랩을 사용하기 위한 선언 -->
<div align="center">
	<br>
	<br>
	<h1>판매 상품 관리</h1>
	
		<form action="manage_product_search.do">
		<br>
		검색 선택:
		<select name="query">
		<option value="pBrand">브랜드명</option>
		<option value="pName">제품명</option>
		<option value="pSize">사이즈</option>
		
		</select>&nbsp;&nbsp;&nbsp;
		<!-- &nbsp;는 띄어쓰기 -->
		<input type="text" name="content" size="30">
		<input type="submit"value="검색">
	</form>
		<br>
	<br>
	<table border="1"
	class="table table-hover table-bordered border-secondary"
			style="width: 100%; margin: auto;"
	>
		<tr>
			<th> 제품 번호 </th><th> 주문번호 </th>
			<th style="WIDTH: 80pt; height: 20pt"> 제조회사 상품 번호 </th><th > 브랜드명 </th><th>제품 이름 </th>
			<th> 가격 </th><th> 카테고리 </th><th>사이즈</th>
			<th style="WIDTH: 60pt; height: 20pt">재고 수량</th>
			<th style="WIDTH: 140pt; height: 20pt">재고 수량 수정일자</th>
			<th style="WIDTH: 60pt; height: 20pt">이미지</th>
			<th style="WIDTH: 120pt; height: 20pt">제품 상세정보</th>
			<th >삭제</th><th>재고요청</th>
		</tr>
		
		<c:forEach items="${manage_product}" var="dto"><!-- 이페이지의 각각의 속성들을 dto로 보내서 보려는 기능을 사용하려고 dto선언 -->
			<tr>
				<td >${dto.pId}</td>
				<td >${dto.take_tId}</td>
				<td>${dto.take_manufacturer_mfId}</td>
				<td>${dto.pBrand}</td>
				<td><a href="product_select.do?pId=${dto.pId}">${dto.pName}</a></td>
				<td>${dto.pPrice}</td>
				<td>${dto.pCategory}</td>
				<td>${dto.pSize}</td>
				<td>${dto.pStock}</td>
				<td>${dto.pStockdate}</td>
				<td><img name="image" src="assets/img/product/${dto.pBrand}/${dto.pName}.png" width="100"></td>
				<td>${dto.pInformation}</td>
				<td><a href="HMPproduct_delete.do?pId=${dto.pId}">삭제</a></td>
				<td><a href="HMPproduct_insert.do?pName=${dto.pName}">재고 요청</a></td>
				<!-- HMPInsertCommand.do가 작동되면 take에 재고 요청을 insert하는 것으로 작성 -->
			</tr>
		
		</c:forEach>
		

	</table>
</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="foot.jsp"%>
	<!-- Start Script -->
	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/templatemo.js"></script>
	<script src="assets/js/custom.js"></script>
	<!-- End Script -->

	<!-- Start Slider Script -->
	<script src="assets/js/slick.min.js"></script>
	<script>
		$('#carousel-related-product').slick({
			infinite : true,
			arrows : false,
			slidesToShow : 4,
			slidesToScroll : 3,
			dots : true,
			responsive : [ {
				breakpoint : 1024,
				settings : {
					slidesToShow : 3,
					slidesToScroll : 3
				}
			}, {
				breakpoint : 600,
				settings : {
					slidesToShow : 2,
					slidesToScroll : 3
				}
			}, {
				breakpoint : 480,
				settings : {
					slidesToShow : 2,
					slidesToScroll : 3
				}
			} ]
		});
	</script>
</body>
</html>