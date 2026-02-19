package org.example.tests.crud;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants_URLs;
import org.example.POJOs.response.BookingResponse;
import org.example.base.BaseClass_CommonTOAll;
import org.testng.annotations.Test;

import javax.swing.*;

public class CreateToken extends BaseClass_CommonTOAll {

    @Test(groups = "reg", priority = 1)
    @Description("#2. Create token and verify")

       public void testtokenpost(){

        //Preparation of the request
            requestSpecification.basePath(APIConstants_URLs.AUTH_URL);

            //Making of the request
            response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).log().all().post();

            //Extraction (Json string response to java object)
            String token = payloadManager.gettokenfromjson(response.asString());
            assertactions.VerifyStringkeynotnull(token);
        System.out.println(token);

    }

}