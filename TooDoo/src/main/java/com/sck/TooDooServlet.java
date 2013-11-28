package com.sck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TooDooServlet {

	public static String getTooDooListByName(String name)
			throws JsonGenerationException, JsonMappingException, IOException,
			SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");

		Connector connect = new Connector(con);
		 TooDooItem[] list = connect.findAllTodoByUserID("Mon");

		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(list);

		return output;
	}

}
