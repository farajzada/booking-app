package az.edu.turing.bookingapp.model.response;


import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private Long id;

    private String origin;

    private String destination;

    private Long availableSeats;
    private LocalDateTime timestamp;
}
