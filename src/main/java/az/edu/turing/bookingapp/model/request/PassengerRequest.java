package az.edu.turing.bookingapp.model.request;

import jakarta.validation.constraints.NotBlank;

public class PassengerRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "passport number is required")
    private String passportNumber;
}
