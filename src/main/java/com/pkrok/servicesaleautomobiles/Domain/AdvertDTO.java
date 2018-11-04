package com.pkrok.servicesaleautomobiles.Domain;

import com.pkrok.servicesaleautomobiles.Entity.ModelEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class AdvertDTO {
    private Long id;
    private LocalDate start;
    private LocalDate end;
    private ModelEntity model;
}
