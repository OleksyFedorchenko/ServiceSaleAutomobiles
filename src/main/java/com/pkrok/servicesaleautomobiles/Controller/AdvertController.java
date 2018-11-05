package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.AdvertDTO;
import com.pkrok.servicesaleautomobiles.Domain.UserDTO;
import com.pkrok.servicesaleautomobiles.Service.AdvertService;
import com.pkrok.servicesaleautomobiles.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adverts")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    @PostMapping
    public ResponseEntity<?> addAdvert(@RequestBody AdvertDTO advert) {
        advertService.saveAdvert(advert);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AdvertDTO>> getAdverts() {
        List<AdvertDTO> adverts = advertService.findAllAdverts();
        return new ResponseEntity<List<AdvertDTO>>(adverts, HttpStatus.OK);
    }
@GetMapping("{advertID}")
    public ResponseEntity<AdvertDTO> getAdvertById(@PathVariable("advertID") Long id) {
        AdvertDTO advert = advertService.findAdvertById(id);
        return new ResponseEntity<AdvertDTO>(advert, HttpStatus.OK);
    }
    @DeleteMapping("{advertId}")
    public ResponseEntity<?> deleteAdvert(@PathVariable("advertId") Long id){
        advertService.deleteAdvertById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
