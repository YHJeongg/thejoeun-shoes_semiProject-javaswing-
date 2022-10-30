package com.jsplec.hosix.dto;

public class CustomerOrderDto {

	int oSeq;//주문 번호
	String customer_cId;//회원 ID
	int product_pId;//제품 번호
	String oOkdate;//배송 현황 나타내기위한 날짜
	String oAddress;//주소
	int oPrice;//주문 가격
	String pSize;//사이즈
	int oQty;//주문 수량을 보여줌
	String oDate;//주문 시간나타냄
	
	
	public CustomerOrderDto(int oSeq, String customer_cId, int product_pId, String oOkdate, String oAddress, int oPrice,
			String pSize, int oQty, String oDate) {
		super();
		this.oSeq = oSeq;
		this.customer_cId = customer_cId;
		this.product_pId = product_pId;
		this.oOkdate = oOkdate;
		this.oAddress = oAddress;
		this.oPrice = oPrice;
		this.pSize = pSize;
		this.oQty = oQty;
		this.oDate = oDate;
	}//회원 주문 목록을 보기위해 사용되는 field(select문)
	public int getoSeq() {
		return oSeq;
	}


	public void setoSeq(int oSeq) {
		this.oSeq = oSeq;
	}


	public String getCustomer_cId() {
		return customer_cId;
	}


	public void setCustomer_cId(String customer_cId) {
		this.customer_cId = customer_cId;
	}


	public int getProduct_pId() {
		return product_pId;
	}


	public void setProduct_pId(int product_pId) {
		this.product_pId = product_pId;
	}


	public String getoOkdate() {
		return oOkdate;
	}


	public void setoOkdate(String oOkdate) {
		this.oOkdate = oOkdate;
	}


	public String getoAddress() {
		return oAddress;
	}


	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}


	public int getoPrice() {
		return oPrice;
	}


	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}


	public String getpSize() {
		return pSize;
	}


	public void setpSize(String pSize) {
		this.pSize = pSize;
	}


	public int getoQty() {
		return oQty;
	}


	public void setoQty(int oQty) {
		this.oQty = oQty;
	}


	public String getoDate() {
		return oDate;
	}


	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	
}
