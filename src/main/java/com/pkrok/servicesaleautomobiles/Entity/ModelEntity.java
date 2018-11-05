package com.pkrok.servicesaleautomobiles.Entity;

import com.pkrok.servicesaleautomobiles.Enums.DriveUnit;
import com.pkrok.servicesaleautomobiles.Enums.FuelType;
import com.pkrok.servicesaleautomobiles.Enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "model")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "DECIMAL(2,1)")
    private BigDecimal capacity;
    @Enumerated(EnumType.STRING)
    private FuelType fuel;
    @Enumerated(EnumType.STRING)
    private DriveUnit unit;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Column(nullable = false)
    private String color;
    @Column(columnDefinition = "DECIMAL(9,3)")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
