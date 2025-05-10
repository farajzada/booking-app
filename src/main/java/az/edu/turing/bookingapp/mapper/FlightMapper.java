package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightMapper implements EntityMapper<FlightEntity,FlightResponse> {
    @Override
    public FlightEntity toEnt(FlightResponse flightResponse) {
        return FlightEntity.builder()
                .id(flightResponse.getId())
                .availableSeats(flightResponse.getAvailableSeats())
                .origin(flightResponse.getOrigin())
                .destination(flightResponse.getDestination())
                .timestamp(flightResponse.getTimestamp())
                .build();
    }

    @Override
    public List<FlightEntity> toEntity(List<FlightResponse> dtoList) {
        return List.of();
    }

    @Override
    public FlightResponse toDto(FlightEntity flightEntity) {
        return FlightResponse.builder()
                .id(flightEntity.getId())
                .availableSeats(flightEntity.getAvailableSeats())
                .origin(flightEntity.getOrigin())
                .destination(flightEntity.getDestination())
                .timestamp(flightEntity.getTimestamp()).
                build();
    }

    @Override
    public List<FlightResponse> toDtoList(List<FlightEntity> entityList) {
        return List.of();
    }

}