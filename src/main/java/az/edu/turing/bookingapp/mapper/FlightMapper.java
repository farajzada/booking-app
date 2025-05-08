package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.model.request.FlightRequest;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

}
