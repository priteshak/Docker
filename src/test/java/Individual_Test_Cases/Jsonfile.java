package Individual_Test_Cases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Jsonfile {

	public static void main(String[] args) throws FileNotFoundException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		File jsonFile = new File("C:\\Users\\Pritesh\\eclipse-workspace\\EcommerceRestAssured\\src\\test\\java\\Individual_Test_Cases\\loginRequest.json");
		FileReader fr = new FileReader(jsonFile);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		String responseJson = given().log().all().header("Content-Type", "application/json").body(data.toString()).when()
				.post("/api/ecom/auth/login").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(responseJson);
		System.out.println(js.getString("message"));
		String verifyMessage = js.getString("message");
		Assert.assertEquals(verifyMessage, "Login Successfully");
		String token = js.getString("token");
		String userId = js.getString("userId");
	}

}
