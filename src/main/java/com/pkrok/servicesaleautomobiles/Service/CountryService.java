package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.CountryDTO;

import java.util.List;

public interface CountryService {
    void saveCountry(CountryDTO country);

    List<CountryDTO> findAllProducts();

    CountryDTO findCountryById(Long id);

    void deleteCountryById(Long id);
}
