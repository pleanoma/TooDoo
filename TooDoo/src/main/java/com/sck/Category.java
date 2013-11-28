package com.sck;

public class Category {
	private int catID;
	private String catName;
	private String userID;

	public int getCatID() {
		return catID;
	}

	public void setCatID(int iCatID) {
		this.catID = iCatID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String sCatName) {
		this.catName = sCatName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String sUserID) {
		this.userID = sUserID;
	}
}
