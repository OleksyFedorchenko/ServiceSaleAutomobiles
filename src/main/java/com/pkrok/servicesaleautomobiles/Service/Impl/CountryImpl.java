package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.CountryDTO;
import com.pkrok.servicesaleautomobiles.Entity.CountryEntity;
import com.pkrok.servicesaleautomobiles.Repository.CountryRepository;
import com.pkrok.servicesaleautomobiles.Service.CountryService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public void saveCountry(CountryDTO country) {
        CountryEntity countryEntity=modelMapper.map(country,CountryEntity.class);
        countryRepository.save(countryEntity);
    }

    @Override
    public List<CountryDTO> findAllCountries() {
        List<CountryEntity> countryEntities=countryRepository.findAll();
        List<CountryDTO> countryDTOS=modelMapper.mapAll(countryEntities,CountryDTO.class);
        return countryDTOS;
    }

    @Override
    public CountryDTO findCountryById(Long id) {
        CountryEntity countryEntity=countryRepository.findById(id).get();
        CountryDTO countryDTO = modelMapper.map(countryEntity,CountryDTO.class);
        return countryDTO;
    }

    @Override
    public void deleteCountryById(Long id) {
        CountryEntity countryEntity=countryRepository.findById(id).get();
        if(countryEntity!=null){
            countryRepository.deleteById(id);
        }else System.out.println("Country not found");
    }


}
