package com.sck;

import java.io.IOException;
import java.sql.SQLException;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

public class JacksonConverterTest {

	JSONConverter jsonConverter;

	@Before
	public void setup() {
		this.jsonConverter = new JSONConverter();
	}

	@Test
	public void proveJacksonCanWriteJSONUsingCategoryAsAModel()
			throws JsonGenerationException, JsonMappingException, IOException {
		Category cat = new Category();
		cat.setCatName("my cat name");
		cat.setUserID("12345");

		String output = jsonConverter.convertToJSON(cat);

		String expected = "{\"catID\":0,\"catName\":\"my cat name\",\"userID\":\"12345\"}";
		Assert.assertEquals(expected, output);

	}

	@Test
	public void proveQueryDataTooDooListFromDataBasesMySQLAsBModel()
			throws SQLException, JsonGenerationException, JsonMappingException,
			IOException {

		TooDooItem[] list = new TooDooItem[] {
				new TooDooItem(), new TooDooItem()
		};

		String output = jsonConverter.convertToJSON(list);
		Assert.assertEquals("[{\"subject\":null,\"userID\":null,\"catID\":0,\"priority\":null,\"due_date\":null,\"create_Date\":null},{\"subject\":null,\"userID\":null,\"catID\":0,\"priority\":null,\"due_date\":null,\"create_Date\":null}]", output);
	}

}
