<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product_select.pName}정보 수정 및 삭제</title>
</head>
<meta charset="UTF-8">
<script type="text/javascript">//자바 스크립트에서는 간단한 내역만 작성하는게 좋음 모든 코드들이 비춰지기 때문에
	function checkMember(){
//정규화작업 다시해볼것
		var regExpName = /^[가-힣]{3}$/
		var regExpTel = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpAddress=/^[가-힣]{3}$/
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		var regRelation =/^[가-힣]{3}$/
		
		//id, 이름, 비밀번호, 전화번호, 이메일에 대한 정규화
		//!!주의!! *을넣어주면 무시하고 넘어가게됨
		var form=document.Member//밑에 form을 가져오기위해 변수같이 선언
		
		var name =form.name.value
		var tel=form.tel.value
		var address=form.address.value
		var email=form.email.value
		var relation=form.relation.value
		
		if(!regExpName.test(name)){
			alert("이름은 한글만으로 입력해주세요")
			form.name.select()
			return
		}
		if(!regExpPhone.test(tel)){
			alert("연락처 입력을 확인해주세요")
			form.tel.select()
			return
		}
		if(!regExpAddress.test(address)){
			alert("주소 입력을 확인해주세요")
			form.address.select()
			return
		}
		if(!regExpEmail.test(email)){
			alert("이메일 입력을 확인해주세요")
			form.email.select()
			return
		}
		if(!regExpRelation.test(relation)){
			alert("관계 입력을 확인해주세요")
			form.relation.select()
			return
		}
			
		form.submit();
	}

</script>

<body>
<div align="center">
	<h2>정보 수정 및 삭제</h2>
	<form action="manage_product_modify.do" name="document"method="post">
	<input type="hidden" name="pId" value="${product_select.pId}">
		<table border="0">
			<tr>
				<td>상품 번호</td>
				<td>${product_select.pId}</td>
			</tr>
			<tr>
			<tr>
				<td>주문 번호</td>
				<td><input type="text" name="take_tOrderid" size="20" value="${product_select.take_tOrderid}"></td>
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
				<td colspan="2"><input type="submit"value="OK"onclick="checkMember()">&nbsp;&nbsp;&nbsp;<a href="manage_product.do">제품 수정 및 삭제 보기</a>&nbsp;&nbsp;&nbsp;<a href="HMPproduct_delete.do?pId=${product_select.pId}">삭제</a></td>
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