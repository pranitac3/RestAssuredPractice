//package org.restassuredpractice.tests;
//
//import groovy.transform.ASTTest;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class getUserTest {
//
//    @Test
//    public void getPractice() {
//        RestAssured.baseURI = "https://reqres.in/";
//        Response response = RestAssured
//
//                .given()
//                .when()
//                .get("/api/users/2")
//                .then().statusCode(200)
//                .extract().response();
//        System.out.println(response.asString());
//
////        Response from data block
//        Assert.assertEquals(response.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
//        Assert.assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
//        Assert.assertEquals(response.jsonPath().getString("data.last_name"), "Weaver");
//        Assert.assertEquals(response.jsonPath().getString("data.avatar"), "https://reqres.in/img/faces/2-image.jpg");
////        Response from support block
//        Assert.assertEquals(response.jsonPath().getString("support.url"), "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
//        Assert.assertEquals(response.jsonPath().getString("support.text"), "Tired of writing endless social media content? Let Content Caddy generate it for you.");
//
//       System.out.println("All test cases are pass");
//    }
//}
