package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    List<BookingEntity> findByFlight_Id(Long flightId);
}
