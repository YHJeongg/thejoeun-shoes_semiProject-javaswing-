<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product_select.pName} 정보 수정 및 삭제</title>
</head>
<meta charset="UTF-8">

<body>
<div align="center">
	<h2>정보 수정 및 삭제</h2>
	<form action="manage_product_modify.do" name="document"method="post">
	<input type="hidden" name="pId" value="${product_select.pId}">
		<table border="0">
			<tr>
				<td>제품 번호</td>
				<td>${product_select.pId}</td>
			</tr>
			<tr>
			<tr>
				<td>주문 번호</td>
				<td><input type="text" name="take_tId" size="20" value="${product_select.take_tId}"></td>
			</tr>
			<tr>
				<td>제조회사 상품 번호</td>
				<td><input type="text" name="take_manufacturer_mfId" size="20" value="${product_select.take_manufacturer_mfId}"></td>
			</tr>
			<tr>
				<td>브랜드명</td>
				<td><input type="text" name="pBrand" size="20" value="${product_select.pBrand}"></td>
			</tr>
			<tr>
				<td>제품명</td>
				<td><input type="text" name="pName" size="20" value="${product_select.pName}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="pPrice" size="20" value="${product_select.pPrice}"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" name="pCategory" size="20" value="${product_select.pCategory}"></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td><input type="text" name="pSize" size="20" value="${product_select.pSize}"></td>
			</tr>
			<tr>
				<td>남은 수량</td>
				<td><input type="text" name="pStock" size="20" value="${product_select.pStock}"></td>
			</tr>
			<tr>
				<td>이미지</td><!-- 		file로 파일을 가져올 수 있게 함 -->
				<td><img name="image" src="./images/adidas.스니커즈.가젤.129,000.png" width="100"></td>
				<td><input type="file" name="pImage" size="20" ></td>
			</tr>
			<tr>
				<td>제품 상세정보</td>
				<td><input type="text" name="pInformation" size="20" value="${product_select.pInformation}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"value="OK">&nbsp;&nbsp;&nbsp;<a href="manage_product.do">제품 수정 및 삭제 보기</a>&nbsp;&nbsp;&nbsp;<a href="HMPproduct_delete.do?pId=${product_select.pId}">삭제</a></td>
			</tr>	
		</table>
	</form>
	</div>
<!-- 			<tr>
				<td>재고 수정 날짜</td>
				<td><input type="text" name="pStockdate" size="20" value="${product_select.pStockdate}"></td>
			</tr> -->
</body>
</html>