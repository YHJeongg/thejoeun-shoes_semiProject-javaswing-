package com.jsplec.hosix.dto;

import java.security.Timestamp;

public class OrdersDto {
	// Product Details Page 
	// F
	int oSeq;
	String oAddress;
	int oPrice;
	int oQty;
	Timestamp oDate;
	Timestamp oOkdate;
	
	
	
	// C
	public OrdersDto() {
		// TODO Auto-generated constructor stub
	}
	
	// insert 시 필요한 Dto 생성자
	public OrdersDto(int oSeq, String oAddress, int oPrice, int oQty, Timestamp oDate) {
		super();
		this.oSeq = oSeq;
		this.oAddress = oAddress;
		this.oPrice = oPrice;
		this.oQty = oQty;
		this.oDate = oDate;
	}
	
	// 관리자 Update Action 에 필요한 orderDto 생성자
	public int getoSeq() {
		return oSeq;
	}
	
	
	
	// G&S

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

	public int getoQty() {
		return oQty;
	}

	public void setoQty(int oQty) {
		this.oQty = oQty;
	}

	public Timestamp getoDate() {
		return oDate;
	}

	public void setoDate(Timestamp oDate) {
		this.oDate = oDate;
	}

	public Timestamp getoOkdate() {
		return oOkdate;
	}

	public void setoOkdate(Timestamp oOkdate) {
		this.oOkdate = oOkdate;
	}

	public void setoSeq(int oSeq) {
		this.oSeq = oSeq;
	}
	
	
	
	
} // End
