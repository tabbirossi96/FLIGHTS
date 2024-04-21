package com.tarc.flights.controllers;

import com.tarc.flights.models.Company;
import com.tarc.flights.repositories.CompanyRepository;
import com.tarc.flights.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/allCompanies")
    public List<Company> getAllCompanies() {
        return companyService.allCompanies();
    }

    @PostMapping("/agregar")
    public void createFlight(@RequestBody Company company) {
        companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Optional<Company> findFlightById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFlight(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    @PutMapping("/actualizar")
    public Optional<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }
}
