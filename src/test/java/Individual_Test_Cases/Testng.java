package Individual_Test_Cases;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Testng {
	
	@Test
	public void testOne() {
		String responseJson = "{\r\n"
				+ "\"Firstname\": \"Pritesh\",\r\n"
				+ "\"Middlename\": \"Ashok\",\r\n"
				+ "\"Lastname\": \"Khambekar\"\r\n"
				+ "}";
		
		JsonPath js = new JsonPath(responseJson);
		System.out.println(js.getString("Middlename"));
	}
}
