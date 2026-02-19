package org.example.Modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.POJOs.request.Authentication;
import org.example.POJOs.request.Booking;
import org.example.POJOs.request.Bookingdates;
import org.example.POJOs.response.BookingResponse;
import org.example.POJOs.response.TokenResponse;

public class Payload_Manager {

        Gson gson;
    public String CreatepayloadBookingAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Srikanth");
        booking.setLastname("Rangavarula");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-03-01");
        bookingdates.setCheckout("2025-03-10");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking); //booking is a java object

        //Now we need to convert the java object to json
        //Serialization
        gson = new Gson();
        String jsonstringbooking = gson.toJson(booking);
        return jsonstringbooking;
    }

    //Convert json to java object - Deserialization
    public BookingResponse bookingResponse(String responseString)
    {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return  bookingResponse;
    }
    //Jave to Json - serialization
    public String setAuthPayload(){
        Authentication auth = new Authentication();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonpayloadstring = gson.toJson(auth);
        System.out.println("payload is set to: " + jsonpayloadstring);
        return jsonpayloadstring;
    }

    //De serialization  JSON string -> Java object

    public String gettokenfromjson(String tokenresponse){
            gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenresponse,TokenResponse.class);
        return tokenResponse1.getToken();

    }


    public String CreatepayloadBookingWithFakerJS(){

        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.number().numberBetween(100,1000));
        booking.setDepositpaid(faker.bool().bool());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-03-01");
        bookingdates.setCheckout("2025-03-10");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking); //booking is a java object

        //Now we need to convert the java object to json
        //Serialization
        gson = new Gson();
        String jsonstringbooking = gson.toJson(booking);
        return jsonstringbooking;
    }
}
