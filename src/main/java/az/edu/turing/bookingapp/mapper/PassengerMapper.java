package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import az.edu.turing.bookingapp.model.response.PassengerResponse;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PassengerMapper extends EntityMapper<PassengerResponse, PassengerEntity>{
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    @Override
     PassengerEntity toEnt(PassengerResponse passengerResponse);
    @Override
    List<PassengerEntity> toEntList(List<PassengerResponse>passengerResponseList);
    @Override
    PassengerResponse toDto (PassengerEntity passengerEntity);
    @Override
    List<PassengerResponse>toDtoList(List<PassengerEntity>passengerEntityList);

}
