package org.restassuredpractice.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.restassuredpractice.utils.configLoader;
import org.restassuredpractice.utils.specificationBuilder;
import org.restassuredpractice.utils.utility;

import java.io.IOException;

public class stepDefinition {
    Response response;
    @Before
    public void setup() {
       //baseURI = "https://reqres.in/";
    }

    @Given("user performed GET request for endpoint {string}")
    public void userPerformedGetRequestForEndpoint(String getEndpoint) {
        //RestAssured.baseURI = "https://reqres.in/";  //one way
        response = given().when().get(configLoader.getProperty("baseURI") + getEndpoint).then().extract().response(); //another way
        // RestAssured.given().when().log().all() //log is for printing
    }


    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        response.getStatusCode();
        Assert.assertEquals(statusCode, response.getStatusCode());

    }

    @Then("response saved at responsefile")
    public void responseSavedAtResponsefile() {

    }


    @Given("user performed POST request for endpoint {string} with body from {string}")
    public void userPerformedPOSTRequestForEndpointWithBodyFrom(String endpoint, String filepath) throws IOException {

        String body = utility.readJSON(filepath);
        response = given().contentType("application/json").header("x-api-key", "reqres-free-v1").body(body).when().log().all().post(configLoader.getProperty("baseURI") + endpoint).then().log().all().extract().response();
    }

    @And("response saved at {string}")
    public void responseSavedAt(String saveresponse) throws IOException {

        utility.saveResponseFile(saveresponse, response.asPrettyString());
        //RequestSpecification RequestSpecification = RestAssured;

        RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri("URL").setContentType("json").build();
        given().when().spec(requestSpecBuilder);
    }

    @Given("user performed single users request")
    public void userPerformedSingleUsersRequest() {
        response = given().when().log().all().get(configLoader.getProperty("appendURL")).then().log().all().extract().response();
        System.out.println(response.asString());
    }

    @And("page numbers should be {string}")
    public void pageNumbersShouldBe(String page_numbers) {
        Assert.assertEquals(response.jsonPath().getString("page"), page_numbers);
//        Assert.assertEquals(response.jsonPath().getInt("page"), page_numbers);
    }

    @And("email should be {string} in response")
    public void emailShouldBeInResponse(String emailid) {
        Assert.assertEquals(response.jsonPath().getString("data[0].email"), emailid );
    }


    @Given("user hit the endpoint with specificationbuilder")
    public void userHitTheEndpointWithSpecificationbuilder() {
        given().spec(specificationBuilder.requestSpecification()).when().get("api/users?page=2").then().spec(specificationBuilder.responseSpecification());
    }
}




