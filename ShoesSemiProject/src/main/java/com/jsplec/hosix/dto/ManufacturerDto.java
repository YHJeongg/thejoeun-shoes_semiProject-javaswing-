package com.jsplec.hosix.dto;

public class ManufacturerDto {
	
	// Fields
	int mfId;
	String mfName;
	String mfBrand;
	String mfCrn;
	String mfProductname;
	String mfCategoty;
	String mfSize;
	int mfPrice;
	
	// Constructor
	public ManufacturerDto(int mfId, String mfName, String mfBrand, String mfCrn, String mfProductname,
			String mfCategoty, String mfSize, int mfPrice) {
		super();
		this.mfId = mfId;
		this.mfName = mfName;
		this.mfBrand = mfBrand;
		this.mfCrn = mfCrn;
		this.mfProductname = mfProductname;
		this.mfCategoty = mfCategoty;
		this.mfSize = mfSize;
		this.mfPrice = mfPrice;
	}
	
	



	public ManufacturerDto(int mfId, String mfBrand, String mfProductname, String mfCategoty, String mfSize,
			int mfPrice) {
		super();
		this.mfId = mfId;
		this.mfBrand = mfBrand;
		this.mfProductname = mfProductname;
		this.mfCategoty = mfCategoty;
		this.mfSize = mfSize;
		this.mfPrice = mfPrice;
	}





	public int getMfId() {
		return mfId;
	}

	public void setMfId(int mfId) {
		this.mfId = mfId;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public String getMfBrand() {
		return mfBrand;
	}

	public void setMfBrand(String mfBrand) {
		this.mfBrand = mfBrand;
	}

	public String getMfCrn() {
		return mfCrn;
	}

	public void setMfCrn(String mfCrn) {
		this.mfCrn = mfCrn;
	}

	public String getMfProductname() {
		return mfProductname;
	}

	public void setMfProductname(String mfProductname) {
		this.mfProductname = mfProductname;
	}

	public String getMfCategoty() {
		return mfCategoty;
	}

	public void setMfCategoty(String mfCategoty) {
		this.mfCategoty = mfCategoty;
	}

	public String getMfSize() {
		return mfSize;
	}

	public void setMfSize(String mfSize) {
		this.mfSize = mfSize;
	}

	public int getMfPrice() {
		return mfPrice;
	}

	public void setMfPrice(int mfPrice) {
		this.mfPrice = mfPrice;
	}

	
}
