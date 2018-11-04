package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.ModelDTO;

import java.util.List;

public interface ModelService {
    void saveModel(ModelDTO model);

    List<ModelDTO> findAllModels();

    ModelDTO findModelById(Long id);

    void deleteModelById(Long id);
}
