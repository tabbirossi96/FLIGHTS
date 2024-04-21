package com.tarc.flights.utils;

import com.tarc.flights.models.Dolar;
import com.tarc.flights.models.Flight;
import com.tarc.flights.models.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightUtils {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public FlightDto flightMapper(Flight flight, double precio){  //modificar esta funcion para que devuelva una lista  con stream
        return new FlightDto(flight.getId(), flight.getOrigen(), flight.getDestino(), flight.getFechaHoraSalida(),
                flight.getFechaHoraSalida(), flight.getPrecio() * precio, flight.getFrecuencia());

    }

    public List<FlightDto> flightMapper(List<Flight> flights, double precio){
        List<FlightDto> flightDtos =new ArrayList<>();
        for(Flight flight : flights) {
            flightDtos.add(flightMapper(flight,precio));
        }
        return flightDtos;
        }
      }


