package Individual_Test_Cases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Ecommerce_EndToEnd {

	public static void main(String[] args) {

		//Login
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String responseJson = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"userEmail\": \"pritesh.khambekar41@gmail.com\",\r\n"
						+ "    \"userPassword\": \"Automation@12345\"\r\n" + "}")
				.when().post("/api/ecom/auth/login").then().assertThat().statusCode(200).extract().response()
				.asString();

		JsonPath js = new JsonPath(responseJson);
		System.out.println(js.getString("message"));
		String verifyMessage = js.getString("message");
		Assert.assertEquals(verifyMessage, "Login Successfully");
		String token = js.getString("token");
		String userId = js.getString("userId");
		
		//Place Order
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String orderResponse = given().log().all().header("Content-Type","application/json").
				header("Authorization",token).
		body("{\r\n"
				+ "    \"orders\": [\r\n"
				+ "        {\r\n"
				+ "            \"country\": \"India\",\r\n"
				+ "            \"productOrderedId\": \"6262e95ae26b7e1a10e89bf0\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}").
		when().post("/api/ecom/order/create-order")
		.then().log().all().assertThat().statusCode(201).body("message", equalTo("Order Placed Successfully")).extract().response().asString();
		
		JsonPath js1 = new JsonPath(orderResponse);
		String orderId = js1.getString("orders[0]");
		System.out.println(orderId);
		String message = js1.getString("message");
		System.out.println(message);
		
		//OrderDetails
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String orderDetailsResponse = given().log().all().header("Authorization",token).header("Content-Type","application/json")
		.queryParam("id", orderId)
		.when().get("/api/ecom/order/get-orders-details")
		.then().log().all().assertThat().statusCode(200)
		.body("message", equalTo("Orders fetched for customer Successfully"))
		.extract().response().asString();
		
		JsonPath js2 = new JsonPath(orderDetailsResponse);
		String orderDetailsId = js2.getString("data._id");
		System.out.println("Order Details Id is : "+orderDetailsId);
		System.out.println(js2.getString("message"));
		
		//Delete Order
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String deleteOrderResponse = given().log().all().header("Authorization",token).header("Content-Type","application/json")
				.pathParam("orderid", orderDetailsId)
		.when().delete("/api/ecom/order/delete-order/{orderid}")
		.then().log().all().assertThat().statusCode(200).body("message", equalTo("Orders Deleted Successfully")).extract().response().asString();
		
		JsonPath js3 = new JsonPath(deleteOrderResponse);
		System.out.println(js3.getString("message"));
		
	}

}
