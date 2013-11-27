package com.sck;

import java.sql.*;
import java.util.Properties;

import javax.sql.*;

import javax.naming.*;

import java.sql.ResultSet;

public class Connector {
	
	 private Object userName;
	 private Object password;
	
	    public ResultSet executeQuery(String strSql)
	        throws SQLException{

	        Connection con = null;
	        ResultSet rs ;
	        Statement pstmt;
	        try {
	            con = ds.getConnection("root", "1234");
	            con.setAutoCommit(false);
	            pstmt = con.prepareStatement(strSql);

	            rs = pstmt.executeQuery(strSql);
	            ResultSetMetaData md = rs.getMetaData();
	            
	            con.commit();
	            pstmt.close();

	        } finally {
	            if (con != null) con.close();
	        }
			return rs;
	    }
	    
	    public void executeNonQuery(String strSql)
		        throws SQLException{

		        Connection con = null;
		        Statement pstmt;
		        try {
		            con = ds.getConnection("root", "1234");
		            con.setAutoCommit(false);
		            pstmt = con.prepareStatement(strSql);

		            pstmt.executeQuery(strSql);

		            con.commit();
		            pstmt.close();

		        } finally {
		            if (con != null) con.close();
		        }
		    }
	    
	    public Connection getConnection() throws SQLException {

		    Connection conn = null;
		    Properties connectionProps = new Properties();
		    connectionProps.put("user", this.userName);
		    connectionProps.put("password", this.password);

		    
		        conn = DriverManager.getConnection(
		                   "jdbc:mysql://localhost:3306/", connectionProps);
		    
		    System.out.println("Connected to database");
		    return conn;
		}

	    private DataSource ds = null;
		    
	public static void main(String args[]) throws SQLException {
		Connector connector = new Connector();
		ResultSet rs = connector.executeQuery("");
	}
}
