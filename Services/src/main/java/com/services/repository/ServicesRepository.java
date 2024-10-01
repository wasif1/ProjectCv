package com.services.repository;

import com.services.data.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    // Additional query methods can be defined here, if necessary
}
