package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends JpaRepository<FlightEntity, Long> {
}
