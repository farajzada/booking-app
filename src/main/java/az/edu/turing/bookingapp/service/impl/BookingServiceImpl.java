package az.edu.turing.bookingapp.service.impl;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.domain.repository.BookingRepository;
import az.edu.turing.bookingapp.domain.repository.FlightRepository;
import az.edu.turing.bookingapp.domain.repository.PassengerRepository;
import az.edu.turing.bookingapp.exception.ResourceNotFoundException;
import az.edu.turing.bookingapp.mapper.BookingMapper;
import az.edu.turing.bookingapp.model.request.BookingRequest;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import az.edu.turing.bookingapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    @Override
    public List<BookingResponse> findAll() {
        List<BookingEntity> bookingEntityList = bookingRepository.findAll();
        return bookingEntityList.stream()
                .map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public BookingResponse findByID(Long id) {
        BookingEntity bookingEntity = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("booking not found wit id: " + id));
        return bookingMapper.toDto(bookingEntity);

    }

    @Override
    public BookingResponse saveBooking(BookingRequest bookingRequest) {
//        FlightEntity flight = flightRepository.findById(bookingRequest.getFlightId())
//                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + bookingRequest.getFlightId()));
//
//        PassengerEntity passenger = passengerRepository.findById(bookingRequest.getPassengerId())
//                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + bookingRequest.getPassengerId()));
//
//        BookingEntity bookingEntity = new BookingEntity();
//        bookingEntity.setNumberOfSeats(bookingRequest.getNumberOfSeats());
//        bookingEntity.setFlight(flight);
//        bookingEntity.setPassenger(passenger);
//
//        BookingEntity savedBooking = bookingRepository.save(bookingEntity);
//        return bookingMapper.toDto(savedBooking);
        System.out.println("flightId: " + bookingRequest.getFlightId());
        System.out.println("passengerId: " + bookingRequest.getPassengerId());
        if (bookingRequest.getFlightId() == null || bookingRequest.getPassengerId() == null) {
            throw new IllegalArgumentException("Flight ID and Passenger ID must not be null");
        }

        FlightEntity flight = flightRepository.findById(bookingRequest.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        PassengerEntity passenger = passengerRepository.findById(bookingRequest.getPassengerId())
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        BookingEntity booking = BookingEntity.builder()
                .flight(flight)
                .passenger(passenger)
                .numberOfSeats(bookingRequest.getNumberOfSeats())
                .build();

        BookingEntity saved = bookingRepository.save(booking);
        return bookingMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
       if (!bookingRepository.existsById(id)){
           throw new ResourceNotFoundException("booking not found with id: "+id);
       }
       bookingRepository.deleteById(id);

    }

    @Override
    public List<BookingResponse> getBookingsByFlightId(Long id) {
        List<BookingEntity>bookingEntityList=bookingRepository.findByFlight_Id(id);
        return bookingEntityList.stream().map(bookingMapper::toDto).toList();
    }

    @Override
    public boolean hasAvailableSeats(Long flightId, int requiredSeats) {
        FlightEntity flight=flightRepository.findById(flightId)
                .orElseThrow(()->new ResourceNotFoundException("flight not found with id: "+flightId ));
        return flight.getAvailableSeats()>=requiredSeats;
    }

}
