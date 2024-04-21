package com.tarc.flights.controllers;

import com.tarc.flights.models.Dolar;
import com.tarc.flights.models.Flight;
import com.tarc.flights.models.FlightDto;

import com.tarc.flights.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")

public class FlightsController {

    @Autowired
    FlightsService flightsService;


    @GetMapping("/allvuelos")
    public List<FlightDto> getAllFlights() {
        return flightsService.getAllFlights();
    }

    @PostMapping("/agregar")
    public void createFlight(@RequestBody Flight flight, Long companyId) {
        flightsService.createFlight(flight,companyId);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id) {
        return flightsService.findFlightById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightsService.deleteFlightById(id);
    }

    @PutMapping("/actualizar")
    public Flight updateFlight(@RequestBody Flight flight) {

        return flightsService.updateFlight(flight);
    }

    @GetMapping("/origin")
    public List<Flight> getFlightsByLocations(@RequestParam String origin) {
        return flightsService.getByOrigen(origin);
    }

    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origen, @RequestParam String destino) {
        return flightsService.getByOrigenAndDestino(origen, destino);
    }

}