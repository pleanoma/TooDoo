
public class TooDooServlet {

	
	public ResultSet QueryTooDooListByName(String name){
		
		ResultSet dt = null;
		
		sql = "select * from TooDoo_List where User ='"+name+"'";
		
		
		Connector connect = new Connector();
		
		//dt = connect.ex
		return dt;
		
	}
}
