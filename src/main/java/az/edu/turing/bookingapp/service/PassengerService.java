package az.edu.turing.bookingapp.service;

import az.edu.turing.bookingapp.model.request.PassengerRequest;
import az.edu.turing.bookingapp.model.response.PassengerResponse;

import java.util.List;

public interface PassengerService {
    public List<PassengerResponse>findAll();
    public PassengerResponse findById(Long id);
    public PassengerResponse save(PassengerRequest passengerRequest);
    public void deleteById(Long id);
    public PassengerResponse update(Long id, PassengerRequest passengerRequest);

}
