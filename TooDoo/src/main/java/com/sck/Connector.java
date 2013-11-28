package com.sck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		List<TooDooItem> list = new ArrayList<>();
		try {
//			con = DriverManager
//					.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
//			con.setAutoCommit(false);
			pstmt = con.prepareStatement("select * from TooDooList where UserID = ?");
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

	public List<Category> executeQueryCat(String strName)
			throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;

		List<Category> categoryList = new ArrayList<>();

		try {

			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			// pstmt =
			// con.prepareStatement("select UserID,CatName,CatID from Category");
			pstmt = con
					.prepareStatement("select * from TooDooList where UserID = '"
							+ strName + "'");

			rs = pstmt.executeQuery("select * from TooDooList where UserID = '"
					+ strName + "'");

			while (rs.next()) {
				Category cat = new Category();
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
				categoryList.add(cat);
			}

			// con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return categoryList;
	}

	public static Category executeNonQueryCat(String strName)
			throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;
		Category cat = new Category();
		try {
			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			// pstmt =
			// con.prepareStatement("select UserID,CatName,CatID from Category");
			pstmt = con
					.prepareStatement("select * from TooDooList where UserID = '"
							+ strName + "'");

			rs = pstmt.executeQuery("select * from TooDooList where UserID = '"
					+ strName + "'");

			while (rs.next()) {
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
			}

			// con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return cat;
	}
}
