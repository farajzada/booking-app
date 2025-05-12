package az.edu.turing.bookingapp.controller;

import az.edu.turing.bookingapp.model.request.BookingRequest;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import az.edu.turing.bookingapp.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest request) {
        BookingResponse createdBooking = bookingService.saveBooking(request);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        List<BookingResponse> bookings = bookingService.findAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {
        BookingResponse booking = bookingService.findByID(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<BookingResponse>> getBookingsByFlightId(@PathVariable Long flightId) {
        List<BookingResponse> bookings = bookingService.getBookingsByFlightId(flightId);
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
