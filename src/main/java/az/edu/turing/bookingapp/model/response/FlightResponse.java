package az.edu.turing.bookingapp.model.response;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FlightResponse {
    private Long id;

    private String origin;

    private String destination;

    private Long availableSeats;
    private LocalDateTime timestamp;
}
