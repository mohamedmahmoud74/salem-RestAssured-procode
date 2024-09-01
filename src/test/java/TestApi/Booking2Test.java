package TestApi;

import Booking_Api.BookingBody;
import Booking_Api.Bookingdates;
import Services_api.Booking_Api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Booking2Test {
// هنا بقي عملنا كلاس مختلف تماما عن اللي فات تبع الباكدج اللي اسمها  service وحطينا جواه الميثود ديcreateNewBookig
    // والمثود بقي هي اللي هتعمل كل حاجه ويدوبك هنا هنادي عليها ونجط الداتا ونعمل ال assertion
    @Test
    void CreateNewBookingByUsingsService() {
        //Arrange
        BookingBody requestBody =BookingBody
                .builder()
                .setFirstname("Mohmaed")
                .setLastname("Farse")
                .setDepositpaid(true)
                .setAdditionalneeds("BreakFast")
                .setTotalprice(1000)
                .setBookingdates(Bookingdates.builder().setCheckin("2020-01-2").setCheckout("2020-03-20").build())
                .build();

        //Action
        Response res = Booking_Api.createNewBooking(requestBody);
        //Assert
        Assert.assertEquals(res.statusCode(),200);
        Assert.assertTrue(res.jsonPath().getInt("bookingid") >200);
    }
}
