package Booking_Api;


import lombok.Builder;
import lombok.Data;
import lombok.*;

@Data
@Builder(setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
public class Bookingdates {
    private String checkin;
    private String checkout;
}
