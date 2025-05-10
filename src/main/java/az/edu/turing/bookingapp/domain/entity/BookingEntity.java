package az.edu.turing.bookingapp.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number_of_seats")
    private Long numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    @JsonIgnoreProperties (value = {"bookingEntityList"})
    private FlightEntity flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @JsonIgnoreProperties (value = {"bookingEntityList"})
    private PassengerEntity passenger;

}
