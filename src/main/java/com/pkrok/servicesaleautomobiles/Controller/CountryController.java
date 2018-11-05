package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.CityDTO;
import com.pkrok.servicesaleautomobiles.Domain.CountryDTO;
import com.pkrok.servicesaleautomobiles.Domain.UserDTO;
import com.pkrok.servicesaleautomobiles.Service.CountryService;
import com.pkrok.servicesaleautomobiles.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody CountryDTO country) {
        countryService.saveCountry(country);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountries() {
        List<CountryDTO> country = countryService.findAllCountries();
        return new ResponseEntity<List<CountryDTO>>(country, HttpStatus.OK);
    }
@GetMapping("{countryID}")
    public ResponseEntity<CountryDTO> getUserById(@PathVariable("countryID") Long id) {
        CountryDTO country = countryService.findCountryById(id);
        return new ResponseEntity<CountryDTO>(country, HttpStatus.OK);
    }
    @DeleteMapping("{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable("countryId") Long id){
        countryService.deleteCountryById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
