package com.pkrok.servicesaleautomobiles.Repository;

import com.pkrok.servicesaleautomobiles.Entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity,Long> {
}
