package az.edu.turing.bookingapp.service.impl;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.repository.FlightRepository;
import az.edu.turing.bookingapp.mapper.FlightMapper;
import az.edu.turing.bookingapp.model.request.FlightRequest;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import az.edu.turing.bookingapp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightDao;
    private final FlightMapper flightMapper;


    @Override
    public List<FlightResponse> getAllFlights() {
        return flightMapper.toDto(flightDao.findAll());
    }

    @Override
    public FlightResponse getFlightById(Long id) {
        FlightEntity entity = flightDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
        return flightMapper.toDto(entity);
    }

    @Override
    public FlightResponse createFlight(FlightRequest flight) {
        FlightEntity entity = new FlightEntity();
        entity.setOrigin(flight.getOrigin());
        entity.setDestination(flight.getDestination());
        entity.setAvailableSeats(Long.valueOf(flight.getAvailableSeats()));
        entity.setTimestamp(flight.getTimestamp());
        System.out.print(entity);
        FlightEntity savedEntity = flightDao.save(entity);
        return flightMapper.toDto(savedEntity);
    }

    @Override
    public FlightResponse updateFlight(Long id, FlightRequest updatedFlight) {
        FlightEntity entity = flightDao.findById(id)
//                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found with id: " + id));
        entity.setOrigin(updatedFlight.getOrigin());
        entity.setDestination(updatedFlight.getDestination());
        entity.setAvailableSeats(Long.valueOf(updatedFlight.getAvailableSeats()));
        entity.setTimestamp(updatedFlight.getTimestamp());

        return flightMapper.toDto(flightDao.save(entity));
    }

    @Override
    public void deleteFlight(Long id) {
        if (!flightDao.existsById(id)) {
            throw new RuntimeException("Flight not found with id: " + id);
        }
        flightDao.deleteById(id);
    }

    @Override
    public List<FlightResponse> getFlightsInNext24Hours() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24h = now.plusHours(24);
        return flightMapper.toDto(flightDao.findFlightsInNext24Hours(now, next24h));
    }

    @Override
    public List<FlightResponse> searchFlights(String toCity, LocalDate date, int numberOfPassenger) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return flightMapper.toDto(
                flightDao.searchFlights(toCity, start, end, numberOfPassenger)
        );
    }

    @Override
    public boolean hasAvailableSeats(int flightId, int requiredSeats) {
        return flightDao.hasAvailableSeats((long) flightId, requiredSeats);
    }
}
