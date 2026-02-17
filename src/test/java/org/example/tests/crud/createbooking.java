package org.example.tests.crud;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants_URLs;
import org.example.POJOs.response.BookingResponse;
import org.example.base.BaseClass_CommonTOAll;
import org.testng.annotations.Test;

public class createbooking extends BaseClass_CommonTOAll {

    @Test(groups = "reg", priority = 1)
    @Description("#1. Verify that booking is created or not")
    public void testcreatebookingpost_positive(){
            //System.out.println("I'm in positive test");
        //setup and making a request
        requestSpecification.basePath(APIConstants_URLs.Create_update_bookingURL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.CreatepayloadBookingAsString()).post();
        System.out.println(response.asString());
        //Extraction
        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        //Verification
        assertactions.VerifyStringkeynotnull(bookingResponse.getBookingid());
        assertactions.Verifystringkey(bookingResponse.getBooking().getFirstname(),"Srikanth");

    }
}
