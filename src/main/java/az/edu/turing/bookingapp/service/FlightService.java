package az.edu.turing.bookingapp.service;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;

import java.util.List;



public interface FlightService {
    List<FlightEntity> getAllFlights();
    FlightEntity getFlightById(Long id);
    FlightEntity createFlight(FlightEntity flight);
    FlightEntity updateFlight(Long id, FlightEntity updatedFlight);
    void deleteFlight(Long id);
}
