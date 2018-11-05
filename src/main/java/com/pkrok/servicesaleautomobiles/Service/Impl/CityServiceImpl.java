package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.CityDTO;
import com.pkrok.servicesaleautomobiles.Entity.CityEntiity;
import com.pkrok.servicesaleautomobiles.Repository.CityRepository;
import com.pkrok.servicesaleautomobiles.Service.CityService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveCity(CityDTO city) {
        CityEntiity cityEntiity=modelMapper.map(city,CityEntiity.class);
        cityRepository.save(cityEntiity);
    }

    @Override
    public List<CityDTO> findAllCities() {
        List<CityEntiity> cityEntiities=cityRepository.findAll();
        List<CityDTO> cityDTOS=modelMapper.mapAll(cityEntiities,CityDTO.class);
        return cityDTOS;
    }

    @Override
    public CityDTO findCityById(Long id) {
        CityEntiity cityEntiity=cityRepository.findById(id).get();
        CityDTO cityDTO=modelMapper.map(cityEntiity,CityDTO.class);
        return cityDTO;
    }

    @Override
    public void deleteCityById(Long id) {
        CityEntiity cityEntiity=cityRepository.findById(id).get();
        if(cityEntiity!=null){
            cityRepository.deleteById(id);
        }else System.out.println("City not found");
    }

}
