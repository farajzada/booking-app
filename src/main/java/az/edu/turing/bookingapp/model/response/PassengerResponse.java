package az.edu.turing.bookingapp.model.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerResponse {
    private Long id;

    private String name;

    private String surname;

    private String passportNumber;

}
