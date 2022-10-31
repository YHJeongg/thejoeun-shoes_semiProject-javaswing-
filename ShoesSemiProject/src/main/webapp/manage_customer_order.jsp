<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 복사해서 사용하기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 주문목록</title>
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
<div align="center">
<%@include file="header_manage.jsp"%><!-- 부트스트랩을 사용하겠다는 선언 -->
	<h1>회원 주문목록</h1>
	<br><br><br>
		<table border="1" class="table table-hover table-bordered border-secondary"
			style="width: 60%; margin: auto;">
		<tr>
			<th>Seq</th><th>회원 ID</th><th>제품 번호</th><th>진행 상태</th><th>회원 주소</th><th>주문 가격</th>
			<th>사이즈</th><th>주문 수량</th><th>주문 일자</th>
		</tr>
		
		<c:forEach items="${manage_customer_order}" var="dto"><!-- 이페이지의 각각의 속성들을 dto로 보내서 보려는 기능을 사용하려고 dto선언 -->
			<tr>
				<td>${dto.oSeq}</td>
				<td><a href="manage_customer_info.do?cId=${dto.customer_cId}">${dto.customer_cId}</a></td>
				<!-- 회원아이디를 누르면 회원 상세 정보가 나올 수 있도록 조회하는 페이지를 만들어야함 -->
				<td>${dto.product_pId}</td>
				<td>${dto.oOkdate}</td>
				<td>${dto.oAddress}</td>
				<td>${dto.oPrice}</td>
				<td>${dto.pSize}</td>
				<td>${dto.oQty}</td>
				<td>${dto.oDate}</td>
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