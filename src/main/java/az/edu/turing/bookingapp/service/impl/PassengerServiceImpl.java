package az.edu.turing.bookingapp.service.impl;

import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.domain.repository.PassengerRepository;
import az.edu.turing.bookingapp.exception.ResourceNotFoundException;
import az.edu.turing.bookingapp.mapper.PassengerMapper;
import az.edu.turing.bookingapp.model.request.PassengerRequest;
import az.edu.turing.bookingapp.model.response.PassengerResponse;
import az.edu.turing.bookingapp.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private  final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper ;


    @Override
    public List<PassengerResponse> findAll() {
        return passengerRepository.findAll().stream().map(passengerMapper::toDto).toList();
    }

    @Override
    public PassengerResponse findById(Long id) {
        PassengerEntity passengerEntity=passengerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Passenger not found with id: "+id));
        return passengerMapper.toDto(passengerEntity);
    }

    @Override
    public PassengerResponse save(PassengerRequest passengerRequest) {
       PassengerEntity passengerEntity=new PassengerEntity();
       passengerEntity.setName(passengerRequest.getName());
       passengerEntity.setSurname(passengerRequest.getSurname());
       passengerEntity.setPassportNumber(passengerRequest.getPassportNumber());
        PassengerEntity saved = passengerRepository.save(passengerEntity);
        return passengerMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
    if (!passengerRepository.existsById(id)){
        throw new ResourceNotFoundException("Passenger not found with id: "+id);
    }
    passengerRepository.deleteById(id);
    }

    @Override
    public PassengerResponse update(Long id, PassengerRequest passengerRequest) {
        PassengerEntity passengerEntity=passengerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Passenger not found with id: "+id));
        passengerEntity.setName(passengerRequest.getName());
        passengerEntity.setSurname(passengerRequest.getSurname());
        passengerEntity.setPassportNumber(passengerRequest.getPassportNumber());

        return passengerMapper.toDto(passengerEntity);
    }
}
