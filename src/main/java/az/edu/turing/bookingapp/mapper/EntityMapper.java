package az.edu.turing.bookingapp.mapper;

import java.util.List;

public interface EntityMapper<E, D> {

    E toEnt(D d);

    List<E> toEntity(List<D> dtoList);

    D toDto(E e);

    List<D> toDtoList(List<E> entityList);

}
