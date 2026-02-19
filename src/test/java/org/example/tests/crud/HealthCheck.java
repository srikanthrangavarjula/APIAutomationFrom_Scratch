package org.example.tests.crud;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants_URLs;
import org.example.base.BaseClass_CommonTOAll;
import org.testng.annotations.Test;

public class HealthCheck extends BaseClass_CommonTOAll {

    @Test
    @Description("#3. Verify health check")
    public void testhealthcheck(){
        requestSpecification.basePath(APIConstants_URLs.PINGURL);

        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
