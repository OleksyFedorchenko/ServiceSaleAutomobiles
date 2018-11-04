package com.pkrok.servicesaleautomobiles.Domain;

import com.pkrok.servicesaleautomobiles.Entity.ManufacturerEntity;
import com.pkrok.servicesaleautomobiles.Entity.UserEntity;
import com.pkrok.servicesaleautomobiles.Enums.DriveUnit;
import com.pkrok.servicesaleautomobiles.Enums.FuelType;
import com.pkrok.servicesaleautomobiles.Enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

public class ModelDTO {
    private Long id;
    private String name;
    private BigDecimal capacity;
    private FuelType fuel;
    private DriveUnit unit;
    private Transmission transmission;
    private String color;
    private BigDecimal price;
    private ManufacturerEntity manufacturer;
    private UserEntity user;
}
