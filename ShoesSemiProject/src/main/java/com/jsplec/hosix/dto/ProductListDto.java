package com.jsplec.hosix.dto;

import java.security.Timestamp;

public class ProductListDto {
    
    int pId;
    String pBrand;
    String pName;
    int pPrice;
    String pCategory;
    String pSize;
    int pStock;
    String pInformation;
    Timestamp pStockdate;
    
    String cId;
	String cName;
	String cTelno;
    
    public ProductListDto() {
        // TODO Auto-generated constructor stub
    }
    // Product List Constructor
    public ProductListDto(int pId, String pBrand, String pName, int pPrice, String pCategory) {
        super();
        this.pId = pId;
        this.pBrand = pBrand;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pCategory = pCategory;
    }
    
    
    public ProductListDto(int pId, String pBrand, String pName, int pPrice, String pCategory, String pSize, int pStock,
    		String pInformation) {
    	super();
    	this.pId = pId;
    	this.pBrand = pBrand;
    	this.pName = pName;
    	this.pPrice = pPrice;
    	this.pCategory = pCategory;
    	this.pSize = pSize;
    	this.pStock = pStock;
    	this.pInformation = pInformation;
    }
    
    
	public ProductListDto(int pId, String pBrand, String pName, int pPrice, String pCategory, String pSize, int pStock,
			String pInformation, String cName, String cTelno, String cId) {
		super();
		this.pId = pId;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
		this.pSize = pSize;
		this.pStock = pStock;
		this.pInformation = pInformation;
		this.cName = cName;
		this.cTelno = cTelno;
		this.cId = cId;
	}
	// M 
    
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
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
	public int getpStock() {
		return pStock;
	}
	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	public String getpInformation() {
		return pInformation;
	}
	public void setpInformation(String pInformation) {
		this.pInformation = pInformation;
	}
	public Timestamp getpStockdate() {
		return pStockdate;
	}
	public void setpStockdate(Timestamp pStockdate) {
		this.pStockdate = pStockdate;
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
	public void setcTelno(String cId) {
		this.cId = cId;
	}
	public String getcId() {
		return cTelno;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
    


}
