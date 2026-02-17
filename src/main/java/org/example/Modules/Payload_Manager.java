package org.example.Modules;

import com.google.gson.Gson;
import org.example.POJOs.request.Booking;
import org.example.POJOs.request.Bookingdates;
import org.example.POJOs.response.BookingResponse;

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
}
