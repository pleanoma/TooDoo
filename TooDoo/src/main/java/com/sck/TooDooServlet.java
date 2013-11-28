package com.sck;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TooDooServlet {

	public static ResultSet getTooDooListByName(String name){
		
		ResultSet dt = null;
		String sql = null;
		sql = "select * from TooDoo_List where User ='"+name+"'";
				
		Connector connect = new Connector();
		
		
			try {
				dt = connect.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return dt;
	}
	
	public static void main(String args[]){
		
		String User = null;
		ResultSet rs =getTooDooListByName("mon");
	
		try {
			while ( rs.next() ) {
				User = rs.getString("User");
				
				
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


