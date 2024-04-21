package com.tarc.flights.repositories;

import com.tarc.flights.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Long>{
   List<Flight> findByOrigen(String origen);
    List<Flight> findByOrigenAndDestino(String origen, String destino);
}
