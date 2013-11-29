package com.sck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Connector {

	private Connection con;

	public Connector(Connection conn) {
		this.con = conn;
	}

	public TooDooItem[] findAllTodoByUserID(String strName)
			throws SQLException {

		ResultSet rs = null;
		PreparedStatement pstmt;
		List<TooDooItem> list = new ArrayList<TooDooItem>();
		try {
			pstmt = con.prepareStatement("select * from TooDooList where UserID = ? LIMIT 10");
			pstmt.setString(1, strName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TooDooItem item = new TooDooItem();
				item.setId(rs.getInt(1));
				item.setSubject(rs.getString(2));
				item.setDue_date(rs.getString(3));
				item.setUserID(rs.getString(4));
				item.setCatID(rs.getInt(5));
				item.setPriority(rs.getString(6));
				item.setCreate_Date(rs.getString(7));
				list.add(item);
			}
		} finally {
			if (rs != null)
				rs.close();
		}

		return list.toArray(new TooDooItem[list.size()]);
	}

	public Category[] findAllCatByUserID(String strName)
			throws SQLException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt;

		List<Category> listCat = new ArrayList<Category>();

		try {

			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("select * from Category where UserID = ?");
			pstmt.setString(1, strName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Category cat = new Category();
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
				listCat.add(cat);
			
			}

		} finally {
			if (con != null)
				con.close();
		}
		return listCat.toArray(new Category[listCat.size()]);
	}

	public void executeNonQueryCat(String strName)
			throws SQLException {

		Connection con = null;
		PreparedStatement pstmt;
		try {
			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);

			pstmt = con.prepareStatement("insert into TooDoo.TooDooList (Subject,Due_date,UserID,CatID,Priority,Create_date) values	('subject 2',NULL,'Tin',NULL,NULL,'2013-11-28');");

			pstmt.executeUpdate();

			con.commit();
			pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
	}
}
