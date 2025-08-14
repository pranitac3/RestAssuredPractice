package org.restassuredpractice.utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specificationBuilder {

    public static RequestSpecification requestSpecification()
    {
        return new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).addHeader("x-api-key", "reqres-free-v1").log(LogDetail.ALL).build();
    }

    public static ResponseSpecification responseSpecification()
    {
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
        }
    }
