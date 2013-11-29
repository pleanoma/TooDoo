package com.sck;

import org.codehaus.jackson.map.ObjectMapper;

public class JSONConverter {

	private ObjectMapper mapper = new ObjectMapper();

	public String convertToJSON(TooDooItem item) {
		return convertObjectToJSON(item);
	}

	public String convertToJSON(TooDooItem[] items) {
		return convertObjectToJSON(items);
	}

	public String convertToJSON(Category cat) {
		return convertObjectToJSON(cat);
	}

	public String convertToJSON(Category[] cats) {
		return convertObjectToJSON(cats);
	}

	private String convertObjectToJSON(Object item) {
		try {
			return mapper.writeValueAsString(item);
		} catch (Exception e) {
			throw new FailToConvertToJSONException();
		}
	}
}
