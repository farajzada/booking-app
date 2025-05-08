package az.edu.turing.bookingapp.mapper;

import java.util.List;

public interface EntityMapper<D, E> {

    E toEnt(D d);

    D toDto(E e);

    List<E> toEntList(List<D> dtoList);

    List<D> toDtoList(List<E> entList);

}
