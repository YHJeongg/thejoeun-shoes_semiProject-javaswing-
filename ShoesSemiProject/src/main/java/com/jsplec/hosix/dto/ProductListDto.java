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

	public void setpSize(String psize) {
		this.pSize = psize;
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
    

}
