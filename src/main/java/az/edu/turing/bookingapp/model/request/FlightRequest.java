package az.edu.turing.bookingapp.model.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequest {
    private String origin;
    private String destination;
    private Long availableSeats;
    private LocalDateTime timestamp;
}
