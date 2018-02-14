package com.javaex.vo;

public class CategoryVo {
	
	private int userNo;
	private int cateNo;
	String cateName;
	String description;
	String regDate;

	public CategoryVo() {
		
	}
	
	public CategoryVo(int userNo, int cateNo, String cateName, String description, String regDate) {
		this.userNo = userNo;
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CategoryVo [userNo=" + userNo + ", cateNo=" + cateNo + ", cateName=" + cateName + ", description="
				+ description + ", regDate=" + regDate + "]";
	}
	

}
