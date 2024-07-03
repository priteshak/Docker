package Individual_Test_Cases;

import org.json.JSONObject;

public class JsonObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String response = "{\r\n"
				+ "\"name\":\"pritesh\",\r\n"
				+ "\"middleName\":\"ashok\";\r\n"
				+ "\"lastName\":\"khambekar\"\r\n"
				+ "}";
		
		JSONObject json = new JSONObject(response);
		String name = json.getString("name");
		System.out.println(name);


	}

}
