package org.example.tests.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSampleTemplate {

    //Create a booking, create a token
    //Verify that get booking available
    //update the booking
    //delete the booking

    @Test(groups = "qa", priority = 1)
    @Description("TC#1 verify that booking can be created ")
    public void testCreatBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Description("TC#1 verify that booking by ID ")
    public void testVerifybookingbyID(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Description("TC#1 verify updated by booking ID ")
    public void testupdatebookingbyID(){
        Assert.assertTrue(true);
    }
    @Test(groups = "qa", priority = 4)
    @Description("TC#1 verify delete by booking ID ")
    public void testdeletebookingbyID(){
        Assert.assertTrue(true);
    }


}
