package az.edu.turing.bookingapp.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_id")
    @JoinColumn(name = "flight_id")
    private FlightEntity flightId;

    @Column(name = "passenger_id")
    private PassengerEntity passengerId;

    @Column(name = "number_of_seats")
    private Long numberOfSeats;
}
