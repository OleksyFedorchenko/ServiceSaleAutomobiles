package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.AdvertDTO;

import java.util.List;

public interface AdvertService {
    void saveAdvert(AdvertDTO advert);

    List<AdvertDTO> findAllAdverts();

    AdvertDTO findAdvertById(Long id);

    void deleteAdvertById(Long id);
}
