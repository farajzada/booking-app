package az.edu.turing.bookingapp.service.impl;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.repository.FlightDao;
import az.edu.turing.bookingapp.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        return flightDao.findAll();
    }

    @Override
    public FlightEntity getFlightById(Long id) {
        return flightDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));

    }

    @Override
    public FlightEntity createFlight(FlightEntity flight) {
        return flightDao.save(flight);
    }


    @Override
    public FlightEntity updateFlight(Long id, FlightEntity updatedFlight) {
        FlightEntity flight = flightDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));

        flight.setOrigin(updatedFlight.getOrigin());
        flight.setDestination(updatedFlight.getDestination());
        flight.setAvailableSeats(updatedFlight.getAvailableSeats());
        flight.setTimestamp(updatedFlight.getTimestamp());

        return flightDao.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        if (!flightDao.existsById(id)) {
            throw new RuntimeException("Flight not found with id: " + id);
        }
        flightDao.deleteById(id);
    }
}
