package step_definitions;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
//	static {
//		RestAssured.baseURI = "http://dummy.restapiexample.com";
//	   }
	
	
	RequestSpecification requestSpecification;
	Response response;
		
	@Given("Url")
	public void url() {
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		requestSpecification = given().log().all();
	}

	@When("User send Get request for employee with id{string}")
	public void userSendGetRequestForEmployeeWith(String string) {
		response = requestSpecification.when().log().all().get("/api/v1/employee/1");
	}

	@Then("User receives JSON responce for this employee")
	public void userRecievesJSONResponceForThisEmployee() {
		Map mapNew = response.then().log().all().
                assertThat().statusCode(is(200)).body("status", equalTo("success")).extract().as(Map.class);
                
       System.out.println(mapNew);
       
       Map dataOfEmployee = (Map) mapNew.get("data");
       String empName = (String)dataOfEmployee.get("employee_name");
       System.out.println(empName);
	}

	

	
	
	@When("User send Delete request for employee with id {string}")
	public void userSendDeleteRequestForEmployeeWithId(String string) {
		response = requestSpecification.when().log().all().delete("/public/api/v1/delete/1");
	}

	@Then("User receives message {string}")
	public void userReceivesMessage(String string) {
		Map mapNew = response.then().log().all().
                assertThat().statusCode(is(200)).body("message", equalTo(string)).extract().as(Map.class);
                
       System.out.println(mapNew);
	}

	
	
	
}
