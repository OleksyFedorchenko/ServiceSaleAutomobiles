package com.pkrok.servicesaleautomobiles.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "advert")
public class AdvertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate start;

    @Column(nullable = false)
    private LocalDate end;

    @OneToMany
    @JoinColumn(name = "model_id")
    private ModelEntity model;
}
