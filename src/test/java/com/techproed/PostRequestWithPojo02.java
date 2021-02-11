package com.techproed;

import Pojos.BookingDates;
import Pojos.BookingPojo;
import Pojos.BookingResponsePojo;
import TestBase.TestBaseHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PostRequestWithPojo02  extends TestBaseHerOkuApp {
     /*
 	When
 		I send POST Request to the URL https://restful-booker.herokuapp.com/booking
 		with Post Request body  {
								    "firstname": "Eric",
								    "lastname": "Ericson",
								    "totalprice": 900,
								    "depositpaid": false,
								    "bookingdates": {
								        "checkin": "2021-01-07",
								        "checkout": "2021-01-25"
								    }
								}
 	Then
 		Status code is 200
 		And response body is like {
								    "bookingid": 13,
								    "booking": {
								        "firstname": "Eric",
								        "lastname": "Ericson",
								        "totalprice": 900,
								        "depositpaid": false,
								        "bookingdates": {
								            "checkin": "2021-01-07",
								            "checkout": "2021-01-25"
								        }
								     }
								  }

	 */
    @Test
    public void postWithPojo(){
        //url olusturma


        //Beklenen (expected dat) olustur --reqBody
        BookingDates bookingDates = new BookingDates("2021-01-07","2021-01-25");
        BookingPojo expectedBooking = new BookingPojo("Eric","Ericson",900,false,bookingDates);

        //request gonder
        Response response = given().
                                contentType(ContentType.JSON).
                                    spec(spec02).
                                        body(expectedBooking).
                                            when().
                                                 post();
        response.prettyPrint();

        // 1. yol body- pojo
        // 2. yol jsonPath ve pojo


        // Gson
        // Assertion hata verir. Cunku BookingPojo'nun formatı gelen response dan farklı
        // Bu tarz problemlere karsılasılasılırsa ya-- Gson kullanmıyacağız-- jsonPah ve Body
        //                                      ya da yeni bir Pojo Class oluturup response tan gelenleri
        //                                      ekleyecegim.

        // BookingPojo actualBooking = response.as(BookingPojo);
        // Failure---------------------------------

        BookingResponsePojo actualBooking = response.as(BookingResponsePojo.class);
        System.out.println(actualBooking);
        Assert.assertEquals(expectedBooking.getFirstname(),actualBooking.getBooking().getFirstname());
        Assert.assertEquals(expectedBooking.getLastname(),actualBooking.getBooking().getLastname());
        Assert.assertEquals(expectedBooking.getTotalprice(),actualBooking.getBooking().getTotalprice());
        Assert.assertEquals(expectedBooking.isDepositpaid(),actualBooking.getBooking().isDepositpaid());
        Assert.assertEquals(expectedBooking.getBookingdates().getCheckin(),actualBooking.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedBooking.getBookingdates().getCheckout(),actualBooking.getBooking().getBookingdates().getCheckout());





    }


}
