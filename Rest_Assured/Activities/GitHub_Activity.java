import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_Activity {

	String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDo+Pm0m25PMgx0hOvdTAuF72tzvJ1uViwHpBBEw3+y2YEawYndvsft6Qct5jOq9BLnd9swSqYGBo3RX6DiHaCR9cr8UZ/JiXjj6sgFRK6Hf1NRxxt1Z+SNZtrJAIs1Cx0M28X7cg9mbmq3HmBDIzg6Tp6MKU/+gcB9TDngSzpLLQEW7dhw8nNf09+mrvitmYxvxuXbnnmV4yHb/AMOfJy4Bj7GIF7xLAVng7BZAcL/ynYSxwCb1t8+LfSPc3IsBISujPB730JhwsFhR08SLJw6CN1Szb2BjUtzT4n788tmtzfZ4fbUANEvXhdR8f+Ps4hlET3Vwz74ITp+H+z0pzltaznLDjaQm82iHKBNMB67UUbX+usUwpoNvYxjkUx3zKcSk9VFcy5j6p9A6e+e65mTHXODs+8dBVrm550Ulwfysmdt8cffbIJ2ywnw7T8L5I1plDf9jq8QWkf9XfVh7AkhX/q9rJPK8UHi9bR088Tknl/JtcYalGaddVC7OMwZJDk=";
	int id;
	// Declare request & Response specification
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {

		// Create request specification
		requestSpec = new RequestSpecBuilder()
				.addHeader("Authorization", "token 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")
				.setContentType(ContentType.JSON).setBaseUri("https://api.github.com").build();
		responseSpec = new ResponseSpecBuilder()

				// Check response content type
				.expectContentType("application/json")
				// Build response specification
				.build();

	}

	@Test(priority = 1)

	public void PostRequest() {

		String reqBody = "{ \"title\": \"TestAPIKey\",  \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDo+Pm0m25PMgx0hOvdTAuF72tzvJ1uViwHpBBEw3+y2YEawYndvsft6Qct5jOq9BLnd9swSqYGBo3RX6DiHaCR9cr8UZ/JiXjj6sgFRK6Hf1NRxxt1Z+SNZtrJAIs1Cx0M28X7cg9mbmq3HmBDIzg6Tp6MKU/+gcB9TDngSzpLLQEW7dhw8nNf09+mrvitmYxvxuXbnnmV4yHb/AMOfJy4Bj7GIF7xLAVng7BZAcL/ynYSxwCb1t8+LfSPc3IsBISujPB730JhwsFhR08SLJw6CN1Szb2BjUtzT4n788tmtzfZ4fbUANEvXhdR8f+Ps4hlET3Vwz74ITp+H+z0pzltaznLDjaQm82iHKBNMB67UUbX+usUwpoNvYxjkUx3zKcSk9VFcy5j6p9A6e+e65mTHXODs+8dBVrm550Ulwfysmdt8cffbIJ2ywnw7T8L5I1plDf9jq8QWkf9XfVh7AkhX/q9rJPK8UHi9bR088Tknl/JtcYalGaddVC7OMwZJDk=\" }";

		Response response = given().spec(requestSpec).body(reqBody).post("/user/keys");
		// Assertion with response specification
		response.then().spec(responseSpec);

		// Print response
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		id = response.then().extract().path("id");
		System.out.println("Id: " + id);
		Assert.assertEquals(response.getStatusCode(), 201);

	}

	@Test(priority = 2)
	public void GetRequest() {

		Response response = given().spec(requestSpec).get("/user/keys");
		System.out.println(response.getBody().asPrettyString());
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3)
	public void DeleteRequest() {

		Response response = given().spec(requestSpec).pathParam("keyId", id).delete("/user/keys/{keyId}");
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}
}
