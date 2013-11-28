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

	public static ResultSet executeQuery(String strSql) throws SQLException {

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
				Category cat = new Category();
				TooDooList list = new TooDooList();
				
				cat.setUserID(String.valueOf( rs.getInt(1)));
				cat.setCatName(rs.getString(2));
				list.setSubject(rs.getString(2));
				list.setDue_date(Date.valueOf(rs.getString(2)));
				list.setUserID(rs.getString(2));
				list.set;(rs.getString(2));
				list.setDue_date(rs.getString(2));
				list.setDue_date(rs.getString(2));
				list.setDue_date(rs.getString(2));
				list.setDue_date(rs.getString(2));
				list.setDue_date(rs.getString(2));
				
				
				
				String message = rs.getString(5);
				System.out.println(id);
				System.out.println(message);
			}
			
			//con.commit();
			// pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
		return rs;
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
		ResultSet rs = executeQuery("select * from chat order by id");
		System.out.println("dddd");
		/*
		while (rs.next()) {
			//int id = rs.getInt(1);
			String message = rs.getString(5);
			//System.out.println(id);
			System.out.println(message);
		}*/

	}
}
