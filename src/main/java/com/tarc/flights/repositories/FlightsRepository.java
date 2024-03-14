package com.tarc.flights.repositories;

import com.tarc.flights.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long>{
}
