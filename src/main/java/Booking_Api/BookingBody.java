package Booking_Api;

import lombok.Data;



import lombok.*;

@Data
@Builder(setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
public class BookingBody {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;
}
