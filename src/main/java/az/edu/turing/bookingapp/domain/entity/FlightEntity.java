package az.edu.turing.bookingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin", nullable = false)
    private String origin;

    private String destination;

    @Column(name = "available_seats")
    private Long availableSeats;
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "flight",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<BookingEntity> bookingEntityList;

}
