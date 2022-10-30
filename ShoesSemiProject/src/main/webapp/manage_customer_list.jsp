<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 복사해서 사용하기 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록관리 페이지</title>

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
 -->

<meta charset="utf-8">
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
	<%@include file="header.jsp"%>
	<div>
		<br> <br>
		<h1 align="center">회원 목록</h1>
		<br> <br>

		<form action="manage_customer_search.do">
			<div align="center">
				검색 선택 : <select name="query">
					<option value="cId" selected="selected">전체보기</option>
					<option value="cId">아이디</option>
					<option value="cName">이름</option>
				</select>&nbsp;&nbsp;&nbsp;
				<!-- &nbsp;는 띄어쓰기 -->
				<input type="text" name="content" size="30"> <input
					type="submit" value="검색">
			</div>
		</form>
		<br>
		<table border="1"
			class="table table-hover table-bordered border-secondary"
			style="width: 60%; margin: auto;">
			<thead class="table-success">
				<tr style="text-align: center;">
					<th>ID</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>탈퇴일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<form action="manage_customer_delete.do">
						<tr>
							<td><input type="hidden" name="cId" value="${dto.cId}">${dto.cId}</td>
							<td><input type="hidden" name="cName" value="${dto.cName}">${dto.cName}</td>
							<td><input type="hidden" name="cTelno" value="${dto.cTelno}">${dto.cTelno}</td>
							<td><input type="hidden" name="cEmail" value="${dto.cEmail}">${dto.cEmail}</td>
							<td><input type="hidden" name="cAddress" value="${dto.cAddress}">${dto.cAddress}</td>
							<td><input type="hidden" name="cIndate" value="${dto.cIndate}">${dto.cIndate}</td>
							<td><input type="hidden" name="cOutdate" value="${dto.cOutdate}">${dto.cOutdate}</td>
							<td align="center" width="100"><input type="submit"	value="  삭제  " size="40"
								style="background-color: rgb(213, 230, 222); color: red; font-weight: bold; border-style: double;"></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
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
	<!-- End Slider Script -->

	<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
 -->

</body>
</html>