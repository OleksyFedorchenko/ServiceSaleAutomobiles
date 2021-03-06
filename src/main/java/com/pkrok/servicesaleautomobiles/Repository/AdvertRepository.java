package com.pkrok.servicesaleautomobiles.Repository;

import com.pkrok.servicesaleautomobiles.Entity.AdvertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<AdvertEntity, Long> {
}
