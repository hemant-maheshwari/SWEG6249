package sw409.EmployeeAPITest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class EmployeeAPITestMain {

	private final String baseURL = "http://employeebackend-env.eba-i6tjpi7m.us-east-2.elasticbeanstalk.com/api/v1";
	
	@Test
	void testGetAllEmployees() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/employees");
		String responseString = response.getBody().asString();
		System.out.println("Response: "+ responseString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void testCreate() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject employee = new JSONObject();
		employee.put("empName", "Test");
		employee.put("empTitle", "Professor");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(employee.toJSONString());
		Response response = httpRequest.request(Method.POST, "/employees");
		String responseString = response.getBody().asString();
		System.out.println("Response: "+ responseString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String empTitle = response.jsonPath().get("empTitle");
		Assert.assertEquals(empTitle, "Professor");
	}
	
	@Test
	void testUpdate() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject employee = new JSONObject();
		employee.put("empName", "Hemant Maheshwari");
		employee.put("empTitle", "Developer");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(employee.toJSONString());
		Response response = httpRequest.request(Method.PUT, "/employees/1");
		String responseString = response.getBody().asString();
		System.out.println("Response: "+ responseString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void testDelete() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/delete/4");
		String responseString = response.getBody().asString();
		System.out.println("Response: "+ responseString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
}
