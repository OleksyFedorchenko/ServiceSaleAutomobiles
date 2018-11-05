package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.ManufacturerDTO;
import com.pkrok.servicesaleautomobiles.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<?> addManufacturer(@RequestBody ManufacturerDTO manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerDTO>> getManufacturers() {
        List<ManufacturerDTO> manufacturers = manufacturerService.findAllManufacturers();
        return new ResponseEntity<List<ManufacturerDTO>>(manufacturers, HttpStatus.OK);
    }

    @GetMapping("{manufacturerID}")
    public ResponseEntity<ManufacturerDTO> getManufacturerById(@PathVariable("manufacturerID") Long id) {
        ManufacturerDTO manufacturer = manufacturerService.findManufacturerById(id);
        return new ResponseEntity<ManufacturerDTO>(manufacturer, HttpStatus.OK);
    }

    @DeleteMapping("{manufacturerId}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable("manufacturerId") Long id) {
        manufacturerService.deleteManufacturerById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
