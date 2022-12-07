package testcasesusingbdd;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Best way to write API tests using mixed way(bdd+non-bdd)
public class DeleteUsingBDD {

	
	@Test
	public void deleteRecord() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.basePath="/2";
		
		Response response=
		given()
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log().all().extract().response();
		
		String jsonToString=response.asPrettyString();
		System.out.println(jsonToString);
	}
}
