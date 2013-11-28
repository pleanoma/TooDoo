package com.sck;

import java.io.IOException;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class JacksonCategoryTest {

	@Test
	public void proveJacksonCanWriteJSONUsingCategoryAsAModel() throws JsonGenerationException, JsonMappingException, IOException {
		Category cat = new Category();
		cat.setCatName("my cat name");
		cat.setUserID("12345");

		ObjectMapper mapper =new ObjectMapper();
		String output = mapper.writeValueAsString(cat);
		
		
		String expected = "{\"catName\":\"my cat name\",\"userID\":\"12345\"}";
		Assert.assertEquals(expected, output);
	}
}
