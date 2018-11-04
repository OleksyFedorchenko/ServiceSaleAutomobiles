package com.pkrok.servicesaleautomobiles.Domain;

import com.pkrok.servicesaleautomobiles.Entity.CountryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CityDTO {
    private Long id;
    private String name;
    private CountryEntity country;
}
