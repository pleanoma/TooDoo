package com.sck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

public class Connector {

	private Object userName;
	private Object password;
	private DataSource ds = null;

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
				int id = rs.getInt(1);
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
	
	
	public void executeNonQuery(String strSql) throws SQLException {

		Connection con = null;
		Statement pstmt;
		try {
			con = ds.getConnection("webapp", "password");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(strSql);

			pstmt.executeQuery(strSql);

			con.commit();
			pstmt.close();

		} finally {
			if (con != null)
				con.close();
		}
	}
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.0.90/voip:3306/", connectionProps);

		System.out.println("Connected to database");
		return conn;
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
