package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<BookingEntity,Long> {
}
