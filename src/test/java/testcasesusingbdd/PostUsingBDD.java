package testcasesusingbdd;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PostUsingBDD {

	public static HashMap<String,String> map=new HashMap<>();
	
	@BeforeClass
	public void postData() {
		map.put("name",RandomData.getName());
		map.put("job", RandomData.getJob());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	
	@Test
	public void testPost() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.body("name", equalTo(map.get("name")))
			.and()
			.body("job", equalTo(map.get("job")));
	}
	
}
