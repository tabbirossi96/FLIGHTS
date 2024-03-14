package com.tarc.flights.services;

import com.tarc.flights.models.Flights;
import com.tarc.flights.repositories.FlightsRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FlightsService {
    @Autowired
    FlightsRepository fligthsRepository;

    public List<Flights> getAllFlights() {
        return fligthsRepository.findAll();
    }

    public void createFlight(Flights flight) {  //agregar
        fligthsRepository.save(flight);
    }

    public Flights findFlightById(Long id) {  //buscar

        return fligthsRepository.findById(id).orElse(null);
    }

    public void deleteFlightById(Long id) {  //borrar

        fligthsRepository.deleteById(id);

    }

    public Flights updateFlight(Flights flight) {  //actualizar
        fligthsRepository.save(flight);
        return fligthsRepository.findById(flight.getId()).orElse(null);
    }
}