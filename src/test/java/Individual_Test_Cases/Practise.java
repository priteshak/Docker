package Individual_Test_Cases;

import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

public class Practise {

	public static void main(String[] args) {
		
		
		Faker faker = new Faker();
		String fullName = faker.name().fullName();
		System.out.println(fullName);
		
//		List<Map<String,Object>> mainList = new ArrayList<>();
//		
//		Map<String,Object> map1 = new HashMap<>();
//		map1.put("relationship", "Spouse");
//		map1.put("name", "Jane Doe");
//		map1.put("age", 28);
//		
//		Map<String,Object> map2 = new HashMap<>();
//		map2.put("relationship", "Child");
//		map2.put("name", "Samantha Doe");
//		map2.put("age", 5);
//		
//		mainList.add(map1);
//		mainList.add(map2);
//		
//		List<Object> hobbies = new ArrayList<>();
//		hobbies.add("reading");
//		hobbies.add("swimming");
//		hobbies.add("coding");
//		
//		Map<String,Object> contactNumbers = new HashMap<>();
//		contactNumbers.put("home", 12345);
//		contactNumbers.put("work", 54321);
//		contactNumbers.put("mobile", 32145);
//		
//		Map<String,Object> address = new HashMap<>();
//		address.put("street", "123 Main St");
//		address.put("city", "Anytown");
//		address.put("state", "CA");
//		address.put("postal_code", 12345);
//		
//		Map<String,Object> personDetails = new HashMap<>();
//		personDetails.put("name", "John Doe");
//		personDetails.put("age", 30);
//		personDetails.put("address", address);
//		personDetails.put("contact_numbers", contactNumbers);
//		personDetails.put("hobbies", hobbies);
//		personDetails.put("is_student", false);
//		personDetails.put("family_members", mainList);
//		personDetails.put("null_value", null);
//		
//		// Convert the HashMap to JSON format
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = null;
//        try {
//            jsonString = objectMapper.writeValueAsString(personDetails);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Print the JSON string (optional)
//        System.out.println(jsonString);
		
	}

}
