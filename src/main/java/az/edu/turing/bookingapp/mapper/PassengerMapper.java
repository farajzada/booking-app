package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.model.response.FlightResponse;
import az.edu.turing.bookingapp.model.response.PassengerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper extends EntityMapper<PassengerEntity,PassengerResponse> {

    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);
    @Override
    PassengerEntity toEnt(PassengerResponse studentDto);

    @Override
    List<PassengerEntity> toEntity(List<PassengerResponse> studentDtoList);

    @Override
    PassengerResponse toDto(PassengerEntity student);

    @Override
    List<PassengerResponse> toDtoList(List<PassengerEntity> studentList);
}
