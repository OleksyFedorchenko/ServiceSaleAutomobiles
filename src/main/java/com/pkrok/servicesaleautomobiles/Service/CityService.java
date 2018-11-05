package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.CityDTO;

import java.util.List;

public interface CityService {
    void saveCity(CityDTO city);

    List<CityDTO> findAllCities();

    CityDTO findCityById(Long id);

    void deleteCityById(Long id);
}
