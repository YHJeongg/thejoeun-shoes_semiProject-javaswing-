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
	// Fk Key
	String customer_cId;
	int product_pId;
	// others
	String pName;
	String pBrand;
	int pPrice;
	int pSize;
	String cName;
	String cTelno;
	
	
	
	
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
	
	// InsertAction
	public OrdersDto(String oAddress, int oPrice, int oQty, Timestamp oDate, String customer_cId, int product_pId) {
		super();
		this.oAddress = oAddress;
		this.oPrice = oPrice;
		this.oQty = oQty;
		this.oDate = oDate;
		this.customer_cId = customer_cId;
		this.product_pId = product_pId;
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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcTelno() {
		return cTelno;
	}

	public void setcTelno(String cTelno) {
		this.cTelno = cTelno;
	}

	public void setoSeq(int oSeq) {
		this.oSeq = oSeq;
	}
	

} // End
