package az.edu.turing.bookingapp.controller;

import az.edu.turing.bookingapp.domain.entity.FlightEntity;
import az.edu.turing.bookingapp.service.FlightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")

public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightEntity> createFlight(@RequestBody FlightEntity flight) {
        flight.setId(null);
        return ResponseEntity.ok(flightService.createFlight(flight));
    }

    @GetMapping
    public ResponseEntity<List<FlightEntity>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightEntity> getFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightEntity> updateFlight(
            @PathVariable Long id,
            @RequestBody FlightEntity updatedFlight
    ) {
        return ResponseEntity.ok(flightService.updateFlight(id, updatedFlight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
