package com.jsplec.hosix.dto;


public class HManageOrderDto {

	int pId;// 제품 번호
	int take_tId;// 발주 받는 번호
	int take_manufacturer_mfId;// 제조회사 상품 번호
	String pBrand;// 브랜드 명
	String pName;// 제품 명
	int pPrice;// 제품 가격
	String pCategory;// 제품 카테고리
	String pSize;// 220~280사이즈
	int pStock;// 재고 수량
	String pStockdate;// 재고 수정 일자
	String pInformation;// 제품 상세 정보

	// take에 insert하기 위한 field
	String manager_mId;
	int tprice;
	int manufacturer_mfid;
	int mfid;
	String mfProductname;
	String mfSize;
	// String, int, int where은 hosix123, int, String, String

	public HManageOrderDto() {
	}

	public HManageOrderDto(int pId, String pBrand, String pName, int pPrice, String pCategory, String pSize, int pStock,
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
	}// update로 사용하려는 field

	public HManageOrderDto(int pId, int take_tId, int take_manufacturer_mfId, String pBrand, String pName, int pPrice,
			String pCategory, String pSize, int pStock, String pStockdate, String pInformation) {
		super();
		this.pId = pId;
		this.take_tId = take_tId;
		this.take_manufacturer_mfId = take_manufacturer_mfId;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
		this.pSize = pSize;
		this.pStock = pStock;
		this.pStockdate = pStockdate;
		this.pInformation = pInformation;
	}// select로 사용하려는 field

	public HManageOrderDto(int pId, int take_tId, int take_manufacturer_mfId, String pBrand, String pName, int pPrice,
			String pCategory, String pSize, int pStock, String pInformation) {
		super();
		this.pId = pId;
		this.take_tId = take_tId;
		this.take_manufacturer_mfId = take_manufacturer_mfId;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
		this.pSize = pSize;
		this.pStock = pStock;
		this.pInformation = pInformation;
	}//seen에 select로 사용되는 field

	public HManageOrderDto(String pBrand, String pName) {
		super();
		this.pBrand = pBrand;
		this.pName = pName;
	}// 검색을 하기위한 field, select문

	public HManageOrderDto(int mfid, String mfProductname, String mfSize) {
		super();
		this.mfid = mfid;
		this.mfProductname = mfProductname;
		this.mfSize = mfSize;
	}// take에 insert하기 위한 field

	public HManageOrderDto(int pId, String pStockdate, int pStock) {
		super();
		this.pId = pId;
		this.pStockdate = pStockdate;
		this.pStock = pStock;
	}// 재고가 변경되면 재고 날짜를 update해주려는 field

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getTake_tId() {
		return take_tId;
	}

	public void setTake_tId(int take_tId) {
		this.take_tId = take_tId;
	}

	public int getTake_manufacturer_mfId() {
		return take_manufacturer_mfId;
	}

	public void setTake_manufacturer_mfId(int take_manufacturer_mfId) {
		this.take_manufacturer_mfId = take_manufacturer_mfId;
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

	public String getpStockdate() {
		return pStockdate;
	}

	public void setpStockdate(String pStockdate) {
		this.pStockdate = pStockdate;
	}

	public String getpInformation() {
		return pInformation;
	}

	public void setpInformation(String pInformation) {
		this.pInformation = pInformation;
	}

	public String getManager_mId() {
		return manager_mId;
	}

	public void setManager_mId(String manager_mId) {
		this.manager_mId = manager_mId;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public int getManufacturer_mfid() {
		return manufacturer_mfid;
	}

	public void setManufacturer_mfid(int manufacturer_mfid) {
		this.manufacturer_mfid = manufacturer_mfid;
	}

	public int getMfid() {
		return mfid;
	}

	public void setMfid(int mfid) {
		this.mfid = mfid;
	}

	public String getMfProductname() {
		return mfProductname;
	}

	public void setMfProductname(String mfProductname) {
		this.mfProductname = mfProductname;
	}

	public String getMfSize() {
		return mfSize;
	}

	public void setMfSize(String mfSize) {
		this.mfSize = mfSize;
	}



}
