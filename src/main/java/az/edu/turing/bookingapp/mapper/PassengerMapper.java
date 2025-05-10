package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import az.edu.turing.bookingapp.model.response.PassengerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerMapper implements EntityMapper<PassengerEntity, PassengerResponse> {
    @Override
    public PassengerEntity toEnt(PassengerResponse passengerResponse) {
        return PassengerEntity.builder()
                .id(passengerResponse.getId())
                .name(passengerResponse.getName())
                .surname(passengerResponse.getSurname())
                .passportNumber(passengerResponse.getPassportNumber())
                .build();
    }

    @Override
    public List<PassengerEntity> toEntity(List<PassengerResponse> studentDtoList){
        return List.of();
    }

    @Override
    public PassengerResponse toDto(PassengerEntity passengerEntity){
        return PassengerResponse.builder()
                .id(passengerEntity.getId())
                .name(passengerEntity.getName())
                .surname(passengerEntity.getSurname())
                .passportNumber(passengerEntity.getPassportNumber())
                .build();
    }

    @Override
    public List<PassengerResponse> toDtoList(List<PassengerEntity> studentList){
        return List.of();
    }
}
