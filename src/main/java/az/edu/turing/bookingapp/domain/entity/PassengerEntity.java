package az.edu.turing.bookingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passengers")
@Builder
public class PassengerEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    @Column(name = "passport_number")
    private String passportNumber;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<BookingEntity> bookingEntityList;

}
