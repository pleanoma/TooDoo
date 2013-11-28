package com.sck;

public class TooDooItem {
	private int id;
	private String subject;
	private String dueDate;
	private String userID;
	private int catID;
	private String priority;
	private String createDate;

	public void setId(int iid) {
		this.id = iid;
	}

	public int setId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String sSubject) {
		this.subject = sSubject;
	}

	public String getDue_date() {
		return dueDate;
	}

	public void setDue_date(String sDue_date) {
		this.dueDate = sDue_date;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String sUserID) {
		this.userID = sUserID;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int iCatID) {
		this.catID = iCatID;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String sPriority) {
		this.priority = sPriority;
	}

	public String getCreate_Date() {
		return createDate;
	}

	public void setCreate_Date(String sCreate_Date) {
		this.createDate = sCreate_Date;
	}

}
