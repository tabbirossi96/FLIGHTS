package com.tarc.flights.configuration;

import com.tarc.flights.models.Dolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class FlightConfiguration {


    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   public Dolar fetchDolar(){
        RestTemplate restTemplate = this.restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);

    }
}

