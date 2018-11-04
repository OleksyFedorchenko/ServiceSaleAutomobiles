package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.ManufacturerDTO;
import com.pkrok.servicesaleautomobiles.Entity.ManufacturerEntity;
import com.pkrok.servicesaleautomobiles.Repository.ManufacturerRepository;
import com.pkrok.servicesaleautomobiles.Service.ManufacturerService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveManufacturer(ManufacturerDTO manufacturer) {
        ManufacturerEntity manufacturerEntity=modelMapper.map(manufacturer,ManufacturerEntity.class);
        manufacturerRepository.save(manufacturerEntity);
    }

    @Override
    public List<ManufacturerDTO> findAllManufacturers() {
        List<ManufacturerEntity> manufacturerEntities=manufacturerRepository.findAll();
        List<ManufacturerDTO> manufacturerDTOS=modelMapper.mapAll(manufacturerEntities,ManufacturerDTO.class);
        return manufacturerDTOS;
    }

    @Override
    public ManufacturerDTO findManufacturerById(Long id) {
        ManufacturerEntity manufacturerEntity=manufacturerRepository.findById(id).get();
        ManufacturerDTO manufacturerDTO=modelMapper.map(manufacturerEntity,ManufacturerDTO.class);
        return manufacturerDTO;
    }

    @Override
    public void deleteManufacturerById(Long id) {
        ManufacturerEntity manufacturerEntity=manufacturerRepository.findById(id).get();
        if(manufacturerEntity!=null){
            manufacturerRepository.deleteById(id);
        }else System.out.println("Manufacturer not found");
    }


}
