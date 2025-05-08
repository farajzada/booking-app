package az.edu.turing.bookingapp.service.impl;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.domain.repository.BookingRepository;
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
    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @Override
    public List<BookingResponse> findAll() {
        List<BookingEntity> bookingEntityList = bookingRepository.findAll();
        return bookingEntityList.stream()
                .map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public BookingResponse findByID(Long id) {
        BookingEntity bookingEntity=bookingRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("booking not found wit id: "+id));
        return bookingMapper.toDto(bookingEntity);

    }

    @Override
    public BookingResponse saveBooking(BookingRequest bookingRequest) {
//          BookingEntity bookingEntity=new BookingEntity();
//        bookingEntity.setFlight(bookingRequest.getFlightId());
//        bookingEntity.setNumberOfSeats(bookingRequest.getNumberOfSeats());
//        bookingEntity.setP
        return null;

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public BookingResponse getBookingByFlightId(Long id) {
        return null;
    }

    @Override
    public void cancelBooking(Long id) {

    }
}
