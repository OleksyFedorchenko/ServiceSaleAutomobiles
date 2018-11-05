package com.pkrok.servicesaleautomobiles.Repository;

import com.pkrok.servicesaleautomobiles.Entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
