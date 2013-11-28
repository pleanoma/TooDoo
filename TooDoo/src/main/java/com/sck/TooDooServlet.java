package com.sck;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TooDooServlet {

	public static ResultSet getTooDooListByName(String name) {

		ResultSet dt = null;
		String sql = null;
		sql = "select * from TooDooList where UserID ='" + name + "'";
		TooDooList listtoodoo = new TooDooList();

		Connector connect = new Connector();

		try {
			dt = Connector.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dt;
	}

	public static void main(String args[]) {

		
		ResultSet rs = getTooDooListByName("mon");

		
	}
}
