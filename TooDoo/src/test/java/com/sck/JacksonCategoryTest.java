package com.sck;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JacksonCategoryTest {

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

		TooDooItem item = new TooDooItem();

		Connector connect = new Connector();
		item = connect.executeQueryList("s");

		ObjectMapper mapper = new ObjectMapper();
		
		String output = mapper.writeValueAsString(item);
		System.out.println(item);
		System.out.println(output);
	}

	@Test
	public void proveQueryDataCategoryFromDataBasesMySQLAsBModel()
			throws SQLException, JsonGenerationException, JsonMappingException,
			IOException {
		Category cat = new Category();

		Connector connect = new Connector();
		cat = connect.executeQueryCat("");
		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(cat);
		System.out.println(cat);
		System.out.println(output);
	}

}
