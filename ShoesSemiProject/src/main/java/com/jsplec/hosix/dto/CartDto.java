package com.jsplec.hosix.dto;

import java.security.Timestamp;

public class CartDto {

	// F
	int cSeq;
	int cQty;
	Timestamp cDate;
	
	
	// C
	public CartDto() {
		// TODO Auto-generated constructor stub
	}
	

	public CartDto(int cSeq, int cQty, Timestamp cDate) {
		super();
		this.cSeq = cSeq;
		this.cQty = cQty;
		this.cDate = cDate;
	}


	// M

	public int getcSeq() {
		return cSeq;
	}


	public void setcSeq(int cSeq) {
		this.cSeq = cSeq;
	}


	public int getcQty() {
		return cQty;
	}


	public void setcQty(int cQty) {
		this.cQty = cQty;
	}


	public Timestamp getcDate() {
		return cDate;
	}


	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}
	
	
}
