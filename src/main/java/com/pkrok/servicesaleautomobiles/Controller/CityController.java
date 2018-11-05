package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.CityDTO;
import com.pkrok.servicesaleautomobiles.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> addCity(@RequestBody CityDTO city) {
        cityService.saveCity(city);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> getCities() {
        List<CityDTO> cities = cityService.findAllCities();
        return new ResponseEntity<List<CityDTO>>(cities, HttpStatus.OK);
    }

    @GetMapping("{cityID}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable("cityID") Long id) {
        CityDTO city = cityService.findCityById(id);
        return new ResponseEntity<CityDTO>(city, HttpStatus.OK);
    }

    @DeleteMapping("{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable("userId") Long id) {
        cityService.deleteCityById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
