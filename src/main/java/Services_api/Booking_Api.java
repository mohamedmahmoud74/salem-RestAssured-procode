package Services_api;

import Booking_Api.BookingBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Booking_Api {


    public  static Response createNewBooking(BookingBody bookingbody) {
        return given().header("Content-Type", "application/json")
                .body(bookingbody)
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .post("/booking")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}
