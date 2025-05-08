package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
