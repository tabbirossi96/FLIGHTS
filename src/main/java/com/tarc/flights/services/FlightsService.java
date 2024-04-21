package com.tarc.flights.services;

import com.tarc.flights.configuration.FlightConfiguration;
import com.tarc.flights.models.Company;
import com.tarc.flights.models.Flight;
import com.tarc.flights.models.FlightDto;
import com.tarc.flights.repositories.CompanyRepository;
import com.tarc.flights.repositories.FlightsRepository;
import com.tarc.flights.utils.FlightUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {
    @Autowired
    FlightsRepository flightsRepository;
    @Autowired
    FlightUtils flightUtils;
    @Autowired
    FlightConfiguration flightConfiguration;
    @Autowired
    CompanyRepository companyRepository;

    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = flightsRepository.findAll();
        double dolarPrice = getDolar();
        return flightUtils.flightMapper(flightList, dolarPrice);
    }
    public Flight createFlight(Flight flight, Long companyId) {  //agregar
        Optional<Company> company = companyRepository.findById(companyId)
                /*.orElseThrow(() -> new IllegalArgumentException("Company not found"))*/;

        flight.setCompany(company);
        return flightsRepository.save(flight);

        /*   String nombreCompany = flight.getCompany().getName();
        Company compania = companyRepository.findByName(nombreCompany);
        flight.setCompany(compania);
        flightsRepository.save(flight);*/
    }


    public Optional<Flight> findFlightById(Long id) {
        return flightsRepository.findById(id);
    }

    public void deleteFlightById(Long id) {  //borrar
        flightsRepository.deleteById(id);

    }

    public Flight updateFlight(Flight flight) {  //actualizar
        flightsRepository.save(flight);
        return flightsRepository.findById(flight.getId()).orElse(null);
    }

    public  List<Flight> getByOrigen(String origen){
        return flightsRepository.findByOrigen(origen);
    }

    public  List<Flight> getByOrigenAndDestino(String origen, String destino){
        return flightsRepository.findByOrigenAndDestino(origen, destino);
    }

    private double getDolar() {
        return flightConfiguration.fetchDolar().getPromedio();

    }

}