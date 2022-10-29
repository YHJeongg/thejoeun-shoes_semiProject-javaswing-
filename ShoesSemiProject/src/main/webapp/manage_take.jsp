<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 복사해서 사용하기 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Line Board</title>

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
		<h1 align="center">Order Product from manufacturer</h1>
		<br> <br>
		<%
		String queryName = request.getParameter("query");
		String queryContent = request.getParameter("content");

		if (queryName == null) {
			queryName = "mfName";
			queryContent = "";
		}
		%>
		<form action="manage_take_search.do">
			<div align="center">
				검색 선택 : <select name="query">
					<option value="mfBrand" selected="selected">브랜드</option>
					<option value="mfName">상품명</option>
					<option value="mfSize">사이즈</option>
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
					<th scope="col">Id</th>
					<th>브랜드</th>
					<th>상품명</th>
					<th>카테고리</th>
					<th>사이즈</th>
					<th>가격</th>
					<th width="30">수량</th>
					<th>발주</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<form action="manage_take_action.do">
						<tr>
							<td><input type="hidden" name="mfId" value="${dto.mfId}">${dto.mfId}</td>
							<td><input type="hidden" name="mfBrand"
								value="${dto.mfBrand}">${dto.mfBrand}</td>
							<td><input type="hidden" name="mfProductname"
								value="${dto.mfProductname}">${dto.mfProductname}</td>
							<td><input type="hidden" name="mfCategory"
								value="${dto.mfCategory}">${dto.mfCategory}</td>
							<td><input type="hidden" name="mfSize" value="${dto.mfSize}">${dto.mfSize}</td>
							<td><input type="hidden" name="mfPrice"
								value="${dto.mfPrice}">${dto.mfPrice}</td>
							<td align="center" width="100"><input type="text"
								name="tQty" size="5"></td>
							<td align="center" width="100"><input type="submit"
								value="  발주  " size="40"
								style="background-color: rgb(213, 230, 222); color: black; font-weight: bold; border-style: double;"></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8"><a href="write_view.do">-------</a></td>
				</tr>
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