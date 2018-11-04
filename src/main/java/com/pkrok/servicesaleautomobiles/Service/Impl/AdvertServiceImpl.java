package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.AdvertDTO;
import com.pkrok.servicesaleautomobiles.Entity.AdvertEntity;
import com.pkrok.servicesaleautomobiles.Repository.AdvertRepository;
import com.pkrok.servicesaleautomobiles.Service.AdvertService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {
    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveAdvert(AdvertDTO advert) {
        AdvertEntity advertEntity=modelMapper.map(advert,AdvertEntity.class);
        advertRepository.save(advertEntity);
    }

    @Override
    public List<AdvertDTO> findAllAdverts() {
        List<AdvertEntity> advertEntities=advertRepository.findAll();
        List<AdvertDTO> advertDTOS=modelMapper.mapAll(advertEntities,AdvertDTO.class);
        return advertDTOS;
    }

    @Override
    public AdvertDTO findAdvertById(Long id) {
        AdvertEntity advertEntity=advertRepository.findById(id).get();
        AdvertDTO advertDTO=modelMapper.map(advertEntity,AdvertDTO.class);
        return advertDTO;
    }

    @Override
    public void deleteAdvertById(Long id) {
    AdvertEntity advertEntity=advertRepository.findById(id).get();
    if(advertEntity!=null){
        advertRepository.deleteById(id);
    }else System.out.println("Advert not found");
    }
}
