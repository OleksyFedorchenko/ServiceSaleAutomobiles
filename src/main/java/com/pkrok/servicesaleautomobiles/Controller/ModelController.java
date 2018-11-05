package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.ModelDTO;
import com.pkrok.servicesaleautomobiles.Service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping
    public ResponseEntity<?> addModel(@RequestBody ModelDTO model) {
        modelService.saveModel(model);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModelDTO>> getModels() {
        List<ModelDTO> models = modelService.findAllModels();
        return new ResponseEntity<List<ModelDTO>>(models, HttpStatus.OK);
    }
@GetMapping("{modelID}")
    public ResponseEntity<ModelDTO> getModelById(@PathVariable("modelID") Long id) {
        ModelDTO model = modelService.findModelById(id);
        return new ResponseEntity<ModelDTO>(model, HttpStatus.OK);
    }
    @DeleteMapping("{modelId}")
    public ResponseEntity<?> deleteModel(@PathVariable("modelId") Long id){
        modelService.deleteModelById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
