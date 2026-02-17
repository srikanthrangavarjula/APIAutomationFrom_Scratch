package org.example.base;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Endpoints.APIConstants_URLs;
import org.example.Modules.Payload_Manager;
import org.example.asserts.AssertActions;
import org.testng.annotations.*;

public class BaseClass_CommonTOAll {

    //commontoall testcases
    //Baseurl, content type etc
    public RequestSpecification requestSpecification;
    public AssertActions assertactions;
    public Payload_Manager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setup(){
        System.out.println("Test started");
        payloadManager = new Payload_Manager();
        assertactions = new AssertActions();
/*
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants_URLs.base_url);
        requestSpecification.contentType(ContentType.JSON).log().all();*/

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants_URLs.base_url)
                .addHeader("content-Type", "application/json")
                .build().log().all();
    }

    @AfterTest
    public void teardown(){
        System.out.println("Test completed");
    }

}
