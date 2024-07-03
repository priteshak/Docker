package Individual_Test_Cases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nested {
    public static void main(String[] args) {
        // Create a HashMap to represent the JSON structure
        Map<String, Object> requestBody = new HashMap<>();

        // Create nested HashMaps and Lists for the structure
        Map<String, Object> personDetails = new HashMap<>();
        Map<String, Object> addressDetails = new HashMap<>();
        List<String> phoneNumbers = new ArrayList<>();

        List<Map<String, Object>> pets = new ArrayList<>();
        Map<String, Object> pet1 = new HashMap<>();
        Map<String, Object> pet2 = new HashMap<>();

        // Populate the data
        addressDetails.put("street", "123 Main St");
        addressDetails.put("city", "Anytown");
        addressDetails.put("state", "CA");
        addressDetails.put("postal_code", "12345");

        phoneNumbers.add("555-555-5555");
        phoneNumbers.add("555-123-4567");

        personDetails.put("name", "John Doe");
        personDetails.put("age", 30);
        personDetails.put("address", addressDetails);
        personDetails.put("phone_numbers", phoneNumbers);

        pet1.put("name", "Fido");
        pet1.put("species", "Dog");
        pet1.put("age", 5);

        pet2.put("name", "Whiskers");
        pet2.put("species", "Cat");
        pet2.put("age", 3);

        pets.add(pet1);
        pets.add(pet2);

        requestBody.put("person", personDetails);
        requestBody.put("pets", pets);

        // Convert the HashMap to JSON and print it
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonBody = objectMapper.writeValueAsString(requestBody);
            System.out.println(jsonBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // In RestAssured, you would use this requestBody in your request like this:
        // RestAssured.given()
        //    .contentType(ContentType.JSON)
        //    .body(requestBody)
        //    .when()
        //    .post("/your/endpoint");
    }
}