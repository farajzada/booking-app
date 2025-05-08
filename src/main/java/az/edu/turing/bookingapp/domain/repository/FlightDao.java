package az.edu.turing.bookingapp.domain.repository;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightDao extends JpaRepository<FlightEntity, Long> {
    @Query("SELECT f FROM FlightEntity f WHERE f.timestamp BETWEEN :now AND :nextDay")
    List<FlightEntity> findFlightsInNext24Hours(
            @Param("now") LocalDateTime now,
            @Param("nextDay") LocalDateTime nextDay
    );

    @Query("SELECT f FROM FlightEntity f WHERE f.destination = :toCity AND f.timestamp BETWEEN :startOfDay AND :endOfDay AND f.availableSeats >= :numberOfPassengers")
    List<FlightEntity> searchFlights(
            @Param("toCity") String toCity,
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay,
            @Param("numberOfPassengers") int numberOfPassengers
    );

    @Query("SELECT CASE WHEN f.availableSeats >= :requiredSeats THEN true ELSE false END FROM FlightEntity f WHERE f.id = :flightId")
    Boolean hasAvailableSeats(@Param("flightId") Long flightId, @Param("requiredSeats") int requiredSeats);
}

