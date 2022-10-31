package com.jsplec.hosix.dto;

import java.security.Timestamp;

public class CartDto {
    
	String customer_cId;
	int product_pId;
	int cQty;
	Timestamp cDate;
	String pName;
	int pPriceSum;
	int pSize;
	String pBrand;
	int pPrice;
	
    public CartDto(String customer_cId, int product_pId, int cQty, String pName, int pPriceSum, String pBrand, int pPrice) {
        super();
        this.customer_cId = customer_cId;
        this.product_pId = product_pId;
        this.cQty = cQty;
        this.pName = pName;
        this.pPriceSum = pPriceSum;
        this.pBrand = pBrand;
        this.pPrice = pPrice;
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

    public int getpSize() {
        return pSize;
    }

    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public int getpPriceSum() {
        return pPriceSum;
    }

    public void setpPriceSum(int pPriceSum) {
        this.pPriceSum = pPriceSum;
    }
	
    
	
}
