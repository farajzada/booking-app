package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BookingMapper implements EntityMapper<BookingEntity, BookingResponse> {


    @Override
    public BookingEntity toEnt(BookingResponse bookingResponse) {
        return BookingEntity.builder()
                .id(bookingResponse.getId())
                .numberOfSeats(bookingResponse.getNumberOfSeats())
                .flight(FlightEntity.builder()
                        .id(bookingResponse.getFlightId())
                        .build())
                .passenger(PassengerEntity.builder()
                        .id(bookingResponse.getPassengerId())
                        .build())
                .build();


        //id number of seats flight id passenger id
    }

    @Override
    public List<BookingEntity> toEntity(List<BookingResponse> dtoList) {
        return List.of();
    }

    @Override
    public BookingResponse toDto(BookingEntity bookingEntity) {
        return BookingResponse.builder()
                .id(bookingEntity.getId())
                .numberOfSeats(bookingEntity.getNumberOfSeats())
                .flightId(bookingEntity.getFlight().getId())
                .passengerId(bookingEntity.getPassenger().getId())
                .build();
    }

    @Override
    public List<BookingResponse> toDtoList(List<BookingEntity> entityList) {
        return List.of();
    }
}