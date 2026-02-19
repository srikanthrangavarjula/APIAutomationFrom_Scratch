package org.example.tests.eneIntegration;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.Endpoints.APIConstants_URLs;
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
    public void testVerifybookingbyID()
    {
        System.out.println();
    }




    @Test(groups = "qa", priority = 3)
    @Description("TC#3 verify updated by booking ID ")
    public void testupdatebookingbyID(){
        Assert.assertTrue(true);
    }



    @Test(groups = "qa", priority = 4)
    @Description("TC#4 verify delete by booking ID ")
    public void testdeletebookingbyID(){
        Assert.assertTrue(true);
    }


}
