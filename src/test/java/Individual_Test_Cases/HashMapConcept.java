package Individual_Test_Cases;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class HashMapConcept {

	public static void main(String[] args) {

		        // Create a HashMap to represent the JSON structure
		        Map<String, Object> requestBody = new HashMap<>();
		        Map<String, Object> address = new HashMap<>();
		        List<String> phoneNumbers = new ArrayList<>();

		        address.put("street", "123 Main St");
		        address.put("city", "Anytown");
		        address.put("state", "CA");
		        address.put("postal_code", "12345");

		        phoneNumbers.add("555-555-5555");
		        phoneNumbers.add("555-123-4567");

		        requestBody.put("name", "John Doe");
		        requestBody.put("age", 30);
		        requestBody.put("email", "john.doe@example.com");
		        requestBody.put("address", address);
		        requestBody.put("phone_numbers", phoneNumbers);

		        // Convert the HashMap to a JSON string
		        ObjectMapper objectMapper = new ObjectMapper();
		        try {
		            String jsonBody = objectMapper.writeValueAsString(requestBody);
		            System.out.println(jsonBody);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

