package com.sck;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

public class Connector {

	public static TooDooList executeQueryList(String strName) throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;
		TooDooList list = new TooDooList();
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			//pstmt = con.prepareStatement("select * from chat order by id");
			pstmt = con.prepareStatement("select * from TooDooList where UserID = '"+strName+"'");

			rs = pstmt.executeQuery("select * from TooDooList where UserID = '"+strName+"'");
			ResultSetMetaData md = rs.getMetaData();

	
			while (rs.next()) {
				System.out.println("a");
				list.setId(rs.getInt(1));
				list.setSubject(rs.getString(2));
				list.setDue_date(rs.getString(3));
				list.setUserID(rs.getString(4));
				list.setCatID(rs.getInt(5));
				list.setPriority(rs.getString(6));
				list.setCreate_Date(rs.getString(7));
				
			}
		} finally {
			if (con != null)
				con.close();
		}
		return list;
	}
	
	
	public static Category executeQueryCat(String strName) throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;
		Category cat = new Category();
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			//pstmt = con.prepareStatement("select UserID,CatName,CatID from Category");
			pstmt = con.prepareStatement("select * from TooDooList where UserID = '"+strName+"'");

			rs = pstmt.executeQuery("select * from TooDooList where UserID = '"+strName+"'");
			ResultSetMetaData md = rs.getMetaData();
	
			while (rs.next()) {
				System.out.println("a");
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
			}
			
			//con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return cat;
	}
	
	public static Category executeNonQueryCat(String strName) throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;
		Category cat = new Category();
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
			con.setAutoCommit(false);
			//pstmt = con.prepareStatement("select UserID,CatName,CatID from Category");
			pstmt = con.prepareStatement("select * from TooDooList where UserID = '"+strName+"'");

			rs = pstmt.executeQuery("select * from TooDooList where UserID = '"+strName+"'");
			ResultSetMetaData md = rs.getMetaData();
	
			while (rs.next()) {
				System.out.println("a");
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
			}
			
			//con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return cat;
	}
	/*
	public static void main(String[] args) throws SQLException {
		//Connector connector = new Connector();
		TooDooList ppL = executeQueryList("Mon");
		//Category ppC = executeQueryCat("adad");

	}
	*/

}
