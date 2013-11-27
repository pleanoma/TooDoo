import java.sql.ResultSet;
import java.sql.SQLException;
public class TooDooServlet {

	public static ResultSet QueryTooDooListByName(String name){
		
		ResultSet dt = null;
		
		String sql = "select * from TooDoo_List where User ='"+name+"'";
				
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
		
		ResultSet sd = QueryTooDooListByName("mon");
	}
}


