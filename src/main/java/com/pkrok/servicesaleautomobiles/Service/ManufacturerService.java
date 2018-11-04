package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.ManufacturerDTO;

import java.util.List;

public interface ManufacturerService {
    void saveManufacturer(ManufacturerDTO manufacturer);

    List<ManufacturerDTO> findAllManufacturers();

    ManufacturerDTO findManufacturerById(Long id);

    void deleteManufacturerById(Long id);
}
