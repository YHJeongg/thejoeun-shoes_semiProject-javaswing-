package com.jsplec.hosix.dto;

import java.sql.Time;

public class HManageOrderDto {

	
	int pId;//제품 번호
	int take_tOrderid;//발주 받는 번호
	String pBrand;//제품 브랜드 명
	String pName;//제품 명
	int pPrice;//제품 가격
	String pCategory;//제품 카테고리
	String pSize;//220~280사이즈
	Time pStokedate;//재고 수정 일자
	int pStock;//재고 수량
	String pImage;//제품 이미지
	String pInformation;//제품 상세 정보
	
	public HManageOrderDto() {
		
	}

	public HManageOrderDto(int pId, int take_tOrderid, String pBrand, String pName, int pPrice, String pCategory,
			String pSize, Time pStokedate, int pStock, String pImage, String pInformation) {
		super();
		this.pId = pId;
		this.take_tOrderid = take_tOrderid;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
		this.pSize = pSize;
		this.pStokedate = pStokedate;
		this.pStock = pStock;
		this.pImage = pImage;
		this.pInformation = pInformation;
	}



	public int getpId() {
		return pId;
	}



	public void setpId(int pId) {
		this.pId = pId;
	}



	public int getTake_tOrderid() {
		return take_tOrderid;
	}



	public void setTake_tOrderid(int take_tOrderid) {
		this.take_tOrderid = take_tOrderid;
	}



	public String getpBrand() {
		return pBrand;
	}



	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}



	public String getpName() {
		return pName;
	}



	public void setpName(String pName) {
		this.pName = pName;
	}



	public int getpPrice() {
		return pPrice;
	}



	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}



	public String getpCategory() {
		return pCategory;
	}



	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}



	public String getpSize() {
		return pSize;
	}



	public void setpSize(String pSize) {
		this.pSize = pSize;
	}



	public Time getpStokedate() {
		return pStokedate;
	}



	public void setpStokedate(Time pStokedate) {
		this.pStokedate = pStokedate;
	}



	public int getpStock() {
		return pStock;
	}



	public void setpStock(int pStock) {
		this.pStock = pStock;
	}



	public String getpImage() {
		return pImage;
	}



	public void setpImage(String pImage) {
		this.pImage = pImage;
	}



	public String getpInformation() {
		return pInformation;
	}



	public void setpInformation(String pInformation) {
		this.pInformation = pInformation;
	}
	
	
}
