package az.edu.turing.bookingapp.mapper;

import az.edu.turing.bookingapp.domain.entity.BookingEntity;
import az.edu.turing.bookingapp.model.response.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<BookingResponse, BookingEntity> {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    @Override
    BookingEntity toEntity(BookingResponse studentDto);

    @Override
    List<BookingEntity> toEntity(List<BookingResponse> studentDtoList);

    @Override
    BookingResponse toDto(BookingEntity student);

    @Override
    List<BookingResponse> toDto(List<BookingEntity> studentList);
}