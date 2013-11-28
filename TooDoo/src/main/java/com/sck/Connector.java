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
			pstmt = con.prepareStatement("select * from TooDooList");

			rs = pstmt.executeQuery("select * from TooDooList");
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
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("b");
				System.out.println("b");
				System.out.println("b");
				System.out.println(list);
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
			pstmt = con.prepareStatement("select * from Category");

			rs = pstmt.executeQuery("select * from Category");
			ResultSetMetaData md = rs.getMetaData();
	
			while (rs.next()) {
				System.out.println("a");
				cat.setUserID(rs.getString(3));
				cat.setCatID(rs.getInt(1));
				cat.setCatName(rs.getString(2));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			
			//con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return cat;
	}
	
	public static ResultSet executeNonQuery(String strSql) throws SQLException {

		Connection con = null;
		ResultSet rs;
		Statement pstmt;
		try {
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.90/voip?user=webapp&password=password");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(strSql);

			rs = pstmt.executeQuery(strSql);
			ResultSetMetaData md = rs.getMetaData();

	
			while (rs.next()) {
				int id = rs.getInt(1);
				String message = rs.getString(5);
				System.out.println(id);
				System.out.println(message);
			}
			
			con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return rs;
	}

	public static void main(String[] args) throws SQLException {
		//Connector connector = new Connector();
		System.out.println("ssssssssssss");
		TooDooList ppL = executeQueryList("adad");
		//Category ppC = executeQueryCat("adad");
		System.out.println("dddd");
		/*
		while (rs.next()) {
			//int id = rs.getInt(1);
			String message = rs.getString(5);
			//System.out.println(id);
			System.out.println(message);
		}
*/
	}

}
