package com.jsplec.hosix.dto;

public class ProductListDto {
    
    int pId;
    String pBrand;
    String pName;
    int pPrice;
    String pCategory;
    
    public ProductListDto() {
        // TODO Auto-generated constructor stub
    }

    public ProductListDto(int pId, String pBrand, String pName, int pPrice, String pCategory) {
        super();
        this.pId = pId;
        this.pBrand = pBrand;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pCategory = pCategory;
    }

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
    

}
