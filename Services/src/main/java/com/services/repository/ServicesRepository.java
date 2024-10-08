package com.services.repository;

import com.services.data.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    // Additional query methods can be defined here, if necessary

    @Query(value = "SELECT * FROM services WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Services>> findByUserId(Long user_id);
}
