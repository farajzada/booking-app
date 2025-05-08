package az.edu.turing.bookingapp.service;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.model.request.FlightRequest;
import az.edu.turing.bookingapp.model.response.FlightResponse;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<FlightResponse> getAllFlights();
    FlightResponse getFlightById(Long id);
    FlightResponse createFlight(FlightRequest flight);
    FlightResponse updateFlight(Long id, FlightRequest updatedFlight);
    void deleteFlight(Long id);
    List<FlightResponse> getFlightsInNext24Hours();
    List<FlightResponse> searchFlights(String toCity, LocalDate date, int numberOfPassenger);
    boolean hasAvailableSeats(int flightId, int requiredSeats);


}
