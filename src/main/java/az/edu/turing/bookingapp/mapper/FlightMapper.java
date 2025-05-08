package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.model.request.FlightRequest;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper extends EntityMapper<FlightResponse, FlightEntity> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightEntity toEnt(FlightRequest flightRequest);

    List<FlightEntity> toEntList(List<FlightResponse> flightResponse);

    FlightResponse toDto(FlightEntity flightEntity);

    List<FlightResponse> toDtoList(List<FlightEntity> entityList);
}

