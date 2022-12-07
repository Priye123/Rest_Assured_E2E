package resttestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC06_ValidateAuthentication {

	@Test
	void authorizationTest() {
		
		RestAssured.baseURI="https://api.mailgun.net/v3";
		
		//Basic auth
		PreemptiveBasicAuthScheme basicAuth= new PreemptiveBasicAuthScheme();
		basicAuth.setUserName("api");
		basicAuth.setPassword("7deee82edc3b49de8aded021f4db6dc1-8ed21946-609a47e6");
		
		//RestAssured.authentication=basicAuth;
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/domains");
		
		System.out.println(response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(),401);
			
	}
		
}
