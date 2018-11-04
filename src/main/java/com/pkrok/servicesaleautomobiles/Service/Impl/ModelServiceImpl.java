package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.ManufacturerDTO;
import com.pkrok.servicesaleautomobiles.Domain.ModelDTO;
import com.pkrok.servicesaleautomobiles.Entity.ModelEntity;
import com.pkrok.servicesaleautomobiles.Repository.ModelRepository;
import com.pkrok.servicesaleautomobiles.Service.ModelService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveModel(ModelDTO model) {
        ModelEntity modelEntity=modelMapper.map(model,ModelEntity.class);
        modelRepository.save(modelEntity);
    }

    @Override
    public List<ModelDTO> findAllModels() {
        List<ModelEntity> modelEntities=modelRepository.findAll();
        List<ModelDTO> modelDTOS=modelMapper.mapAll(modelEntities, ModelDTO.class);
        return modelDTOS;
    }

    @Override
    public ModelDTO findModelById(Long id) {
        ModelEntity modelEntity=modelRepository.findById(id).get();
        ModelDTO modelDTO = modelMapper.map(modelEntity,ModelDTO.class);
        return modelDTO;
    }

    @Override
    public void deleteModelById(Long id) {
        ModelEntity modelEntity=modelRepository.findById(id).get();
        if(modelEntity!=null){
            modelRepository.deleteById(id);
        }else System.out.println("Model not found");
    }

}
