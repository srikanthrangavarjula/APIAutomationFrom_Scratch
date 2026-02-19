package org.example.tests.eneIntegration;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants_URLs;
import org.example.POJOs.request.Booking;
import org.example.POJOs.response.BookingResponse;
import org.example.base.BaseClass_CommonTOAll;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1 extends BaseClass_CommonTOAll {

    //End to end scenario
    //Createbooking -> BookingID
    // Create token
    //Verify that create booking is working
    //update the booking (bookingid,token) need to get the token and bookingid from above
    //Delete the booking - need to get token, bookingid from above request

    @Test(groups = "qa", priority = 1)
    @Description("TC#1 verify that booking can be created ")
    public void testCreatBooking(ITestContext ITestcontext)
    {

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

            ITestcontext.setAttribute("bookingid", bookingResponse.getBookingid());

        }

    @Test(groups = "qa", priority = 2)
    @Description("TC#2 verify the booking by ID ")
    public void testVerifybookingbyID(ITestContext ITestcontext)
    {
        Integer bookingid = (Integer) ITestcontext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants_URLs.Create_update_bookingURL + "/" + bookingid);
        response = RestAssured.given(requestSpecification).when().get();
        Booking booking = new Gson().fromJson(response.asString(), Booking.class);
        assertactions.Verifystringkey(booking.getFirstname(), "Srikanth");
    }

    @Test(groups = "qa", priority = 3)
    @Description("TC#3 verify updated by booking ID ")
    public void testupdatebookingbyID(ITestContext ITestcontext){
        String token = RestAssured.given().baseUri(APIConstants_URLs.base_url)
                .basePath(APIConstants_URLs.AUTH_URL).contentType("application/json")
                .body(payloadManager.setAuthPayload()).post().then().extract().path("token");
        Integer bookingid = (Integer) ITestcontext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants_URLs.Create_update_bookingURL + "/" + bookingid);
        response = RestAssured.given(requestSpecification).cookie("token", token)
                .when().body(payloadManager.CreatepayloadBookingAsString()).put();
        //assertactions.VerifyStatusCode(response.getStatusCode(), 200);
    }

    @Test(groups = "qa", priority = 4)
    @Description("TC#4 verify delete by booking ID ")
    public void testdeletebookingbyID(ITestContext ITestcontext){
        String token = RestAssured.given().baseUri(APIConstants_URLs.base_url)
                .basePath(APIConstants_URLs.AUTH_URL).contentType("application/json")
                .body(payloadManager.setAuthPayload()).post().then().extract().path("token");
        Integer bookingid = (Integer) ITestcontext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants_URLs.Create_update_bookingURL + "/" + bookingid);
        response = RestAssured.given(requestSpecification).cookie("token", token).when().delete();
        //assertactions.VerifyStatusCode(response.getStatusCode(), 201);
    }


}
