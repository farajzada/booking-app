package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<PassengerEntity,Long> {
}
