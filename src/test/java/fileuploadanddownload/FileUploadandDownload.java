package fileuploadanddownload;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FileUploadandDownload {

	@Test
	void fileUpload() {

		File file = new File("C:\\Users\\priran\\Downloads\\827793.png");

		Response res = given().multiPart("file", file, "multipart/form-data").when()
				.post("http://the-internet.herokuapp.com/upload");

		System.out.println(res.asPrettyString());

	}
	
	@Test
	void fileDownload() throws IOException {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		byte[] bytes=res.getBody().asByteArray();
		File file=new File("C:\\Users\\priran\\eclipse-workspace\\RestAssuredPractices\\src\\test\\java\\filedownload.json");
		Files.write(file.toPath(), bytes);
	}

}
