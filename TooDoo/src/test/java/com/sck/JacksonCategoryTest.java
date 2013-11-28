package com.sck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class JacksonCategoryTest {
	
	private Connection con;

	@Before
	public void setup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
	}

	@Test
	public void proveJacksonCanWriteJSONUsingCategoryAsAModel()
			throws JsonGenerationException, JsonMappingException, IOException {
		Category cat = new Category();
		cat.setCatName("my cat name");
		cat.setUserID("12345");

		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(cat);

		String expected = "{\"catID\":0,\"catName\":\"my cat name\",\"userID\":\"12345\"}";
		Assert.assertEquals(expected, output);
		
	}

	@Test
	public void proveQueryDataTooDooListFromDataBasesMySQLAsBModel()
			throws SQLException, JsonGenerationException, JsonMappingException,
			IOException {

		Connector connect = new Connector(con);
		TooDooItem[] list = connect.findAllTodoByUserID("Mon");

		ObjectMapper mapper = new ObjectMapper();
		
		String output = mapper.writeValueAsString(list);
		System.out.println(output);
	}

	@Test
	public void proveQueryDataCategoryFromDataBasesMySQLAsBModel()
			throws SQLException, JsonGenerationException, JsonMappingException,
			IOException {

		Connector connect = new Connector(con);
		List<Category> cat = connect.executeQueryCat("");
		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(cat);
		System.out.println(cat);
		System.out.println(output);
	}

}
