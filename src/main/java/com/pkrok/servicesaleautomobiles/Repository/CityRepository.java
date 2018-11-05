package com.pkrok.servicesaleautomobiles.Repository;

import com.pkrok.servicesaleautomobiles.Entity.CityEntiity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntiity, Long> {
}
