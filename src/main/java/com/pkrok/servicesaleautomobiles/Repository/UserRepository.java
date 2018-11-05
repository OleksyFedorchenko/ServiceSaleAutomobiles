package com.pkrok.servicesaleautomobiles.Repository;

import com.pkrok.servicesaleautomobiles.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
