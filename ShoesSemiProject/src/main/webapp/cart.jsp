<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>HosiX Cart</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">

</head>
<body>

	<!-- include Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Start Content -->
	<div class="container py-5">
		<div class="row">
			<div class="col-lg-10">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>상품 이미지</th>
							<th>상품 이름</th>
							<th>상품 수량</th>
							<th>상품 가격</th>
							<th>상품 삭제</th>
						</tr>
					</thead>
					<c:forEach items="${cartlist}" var="dto">
						<tr>
							<td><img width="100" height="100" src="assets/img/product/${dto.pBrand}/${dto.pName}.png"></td>
							<td>${dto.pName}</td>
							<td>${dto.cQty}</td>
							<td><fmt:formatNumber value="${dto.pPrice * dto.cQty}" groupingUsed="true" /> 원</td>
							<td><a href="#">X</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<!--End Brands-->


	<jsp:include page="foot.jsp"></jsp:include>

	<!-- Start Script -->
	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/templatemo.js"></script>
	<script src="assets/js/custom.js"></script>
	<!-- End Script -->
</body>

</html>