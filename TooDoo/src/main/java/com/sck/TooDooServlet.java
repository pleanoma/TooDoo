package com.sck;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TooDooServlet {

	public static String getTooDooListByName(String name)
			throws JsonGenerationException, JsonMappingException, IOException {

		Category cat = new Category();
		cat.setCatName("my cat name");
		cat.setUserID("12345");

		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(cat);

		
		return output;
	}

}
