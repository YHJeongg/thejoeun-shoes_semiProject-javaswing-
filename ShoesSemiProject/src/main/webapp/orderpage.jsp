<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>HosiX Orders Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">

    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->

<script type="text/javascript">
	function checkForm() {
		alert("주문이 완료되었습니다. 감사합니다.")
				location.href= "index.jsp?page="
	}
</script>
</head>
<body>
<%
int num1 = Integer.parseInt(request.getParameter("pPrice"));
int num2 = Integer.parseInt(request.getParameter("cQty"));
int mul = num1*num2;
%>
    <!-- Start Top Nav -->
<%@include file = "header.jsp" %>
    <!-- Close Top Nav -->

	<h2 align="center"><b>주문하기</b></h2>
 
	<form action="insertOrder.do" method="get"> 
		<table class="container" border="1">
			<tr>
			<td><input type="hidden" name="customer_cId"  id="cId" value='<%=request.getParameter("cId")%>'></td>
			<td><input type="hidden" name="product_pId" id="pId" value='<%=request.getParameter("pId")%>'></td>
				<td>이름 : ${orderpage.cName} </td>
			</tr>
			<tr>
				<td>전화번호 : ${orderpage.cTelno}</td>
			</tr>
			<tr>
				<td>배송지 : 
				<input type="text" name="oAddress" id="oAddress" size="50"></td>
			</tr>
			<tr>
				<td>상품명 : ${orderpage.pName}</td>
			</tr>
			<tr>
				<td>사이즈 : ${orderpage.pSize}</td>
			</tr>
			<tr>
				<td>상품금액 : ${orderpage.pPrice}</td>
			</tr>
			<tr>
				<td>수량 : <%=request.getParameter("cQty") %>개
				<input type="hidden" name="cQty" value='<%=request.getParameter("cQty")%>'> </td>
			</tr>
			<tr>
				<td>총금액 : <%=mul%>
				<input type="hidden" name="pPrice" value='<%=request.getParameter("pPrice")%>'></td>
			</tr>

		
		</table>
		<input type="submit" name="buy" value="구매하기" onclick="checkForm()">
	</form>
 
 
 
 
 
    
    

 	<!-- Start Footer -->
 <%@include file = "foot.jsp" %>
    <!-- End Footer -->

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
            infinite: true,
            arrows: false,
            slidesToShow: 4,
            slidesToScroll: 3,
            dots: true,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                }
            ]
        });
    </script>
    <!-- End Slider Script -->
</body>
</html>