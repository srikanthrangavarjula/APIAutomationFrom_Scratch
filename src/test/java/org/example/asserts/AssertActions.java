package org.example.asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions {

    public void VerifyResponseBody(String actual,String expected, String description)
    {
        assertEquals(actual,expected,description);
    }
    public void VerifyResponseBody(int actual,int expected, String description)
    {
        assertEquals(actual,expected,description);
    }
    public void verifystatuscode(Response response,Integer expected){
        assertEquals(response.getStatusCode(),expected);
    }
    public void Verifystringkey(String keyexpect,String keyactual){
        assertThat(keyexpect).isNotNull();
        assertThat(keyexpect).isNotBlank();
        assertThat(keyexpect).isEqualTo(keyactual);
    }
    public void VerifyStringkeynotnull(Integer keyexpect){
        assertThat(keyexpect).isNotNull();
    }
    public void VerifyStringkeynotnull(String keyexpect){
        assertThat(keyexpect).isNotNull();
    }
}
