package TestApi;

import Booking_Api.BookingBody;
import Booking_Api.Bookingdates;
import Services_api.Booking_Api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Booking1Test {


    @Test
    void testAuthentication() {
        String requestBody = "{\n" +
                "  \"username\": \"admin\",\n" +
                "  \"password\": \"password123\"\n" +
                "}";
        given()
                .header("Content-Type", "application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .body(requestBody).
                when()
                .post("/auth").
                then()
                .log()
                .all()
                .statusCode(200)
            //   .assertThat().body("$",hasKey("token"))

               .extract()
                .response().getBody().asString().contains("token");
}

// التيست كيس دي اما استخدم الكلاس اللي اسمه BookingBody و BookingDates من غير ماستخدم ال builder
    @Test
    void CreateNewBooking() {
        BookingBody BookingBody =new BookingBody();
        Bookingdates BookingDates=new Bookingdates();
        BookingBody.setFirstname("salem");
        BookingBody.setLastname("salemm2");
        BookingBody.setTotalprice(30);
        BookingBody.setDepositpaid(true);
        BookingDates.setCheckin("2018-01-01");
        BookingBody.setBookingdates(BookingDates);
        BookingDates.setCheckout("2025-01-01");
        BookingBody.setBookingdates(BookingDates);
        BookingBody.setAdditionalneeds("Breakfast");
        given()
                .header("Content-Type", "application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .body(BookingBody).
                when()
                .post("/booking").
                then()
                .log()
                .all()
                .statusCode(200);
                //   .assertThat().body("$",hasKey("token"))

                /*.extract()
                .response().getBody().asString().contains("bookingid");*/
    }
    //  التيست كيس دي اما استخدم الكلاس اللي اسمه BookingBody و BookingDates مع استخدام  ال builder وضيفت الanoutation

    @Test
    void CreateNewBookingByUsingBulider() {
        BookingBody requestBody =BookingBody
                .builder()
                .setFirstname("Mohmaed")
                .setLastname("Farse")
                .setDepositpaid(true)
                .setAdditionalneeds("BreakFast")
                .setTotalprice(1000)
                .setBookingdates(Bookingdates.builder().setCheckin("2020-01-2").setCheckout("2020-03-20").build())
                .build();
        given()
                .header("Content-Type", "application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .body(requestBody).
                when()
                .post("/booking").
                then()
                .log()
                .all()
                .statusCode(200);
        //   .assertThat().body("$",hasKey("token"))

                /*.extract()
                .response().getBody().asString().contains("bookingid");*/
    }

}
