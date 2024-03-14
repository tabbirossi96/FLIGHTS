package com.tarc.flights.controllers;

import com.tarc.flights.models.Flights;
import com.tarc.flights.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")

public class FlightsController {

    @Autowired
    FlightsService flightsService;


    @GetMapping("allvuelos")
    public List<Flights> getAllFlights() {
        return flightsService.getAllFlights();
    }

    @PostMapping("/agregar")
    public void createFlight(@RequestBody Flights flight) {
        flightsService.createFlight(flight);
    }

    @GetMapping("/{id}")
    public Flights findFlightById(@PathVariable Long id) {
        return flightsService.findFlightById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFlightById(@PathVariable Long id) {

        flightsService.deleteFlightById(id);
    }

    @PutMapping("/actualizar")
    public Flights updateFlight(@RequestBody Flights flight) {
        return flightsService.updateFlight(flight);
    }

}