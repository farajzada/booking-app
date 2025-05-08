package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface FlightMapper extends EntityMapper<FlightResponse, FlightEntity> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    @Override
    FlightEntity toEnt(FlightResponse flightResponse);
    @Override
    List<FlightEntity> toEntList(List<FlightResponse>flightResponse);
    @Override
    FlightResponse toDto (FlightEntity flightEntity);
    @Override
    List<FlightResponse>toDtoList(List<FlightEntity>flightEntityList);

}
