package az.edu.turing.bookingapp.controller;


import az.edu.turing.bookingapp.domain.entity.PassengerEntity;
import az.edu.turing.bookingapp.model.request.PassengerRequest;
import az.edu.turing.bookingapp.model.response.PassengerResponse;
import az.edu.turing.bookingapp.service.PassengerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<PassengerResponse>> getAll() {
        List<PassengerResponse> passengerResponseList = passengerService.findAll();
        return ResponseEntity.ok(passengerResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponse> getPassengerById(@PathVariable Long id) {
        PassengerResponse passengerResponse = passengerService.findById(id);
        return ResponseEntity.ok(passengerResponse);
    }

    @PostMapping
    public ResponseEntity<PassengerResponse> createPassenger(@Valid @RequestBody PassengerRequest passengerRequest) {
        PassengerResponse createdPassenger = passengerService.save(passengerRequest);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponse> updatePassenger(
            @PathVariable Long id,
            @RequestBody PassengerRequest passengerRequest) {
        PassengerResponse updatedPassenger = passengerService.update(id, passengerRequest);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id){
        passengerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
