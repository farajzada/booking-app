package az.edu.turing.bookingapp.service;

import az.edu.turing.bookingapp.model.request.BookingRequest;
import az.edu.turing.bookingapp.model.response.BookingResponse;

import java.util.List;

public interface BookingService {
    public List<BookingResponse>findAll();
    public BookingResponse findByID(Long id);
    public BookingResponse saveBooking(BookingRequest bookingRequest);
    public void deleteById(Long id);
    public List<BookingResponse> getBookingsByFlightId(Long id);
    public boolean hasAvailableSeats(Long flightId, int requiredSeats);

}
