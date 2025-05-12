package az.edu.turing.bookingapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    private Long id;
    private Long numberOfSeats;

    private Long flightId;

    private Long passengerId;
    private String passengerFullName;
}
