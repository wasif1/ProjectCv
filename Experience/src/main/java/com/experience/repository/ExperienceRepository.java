package com.experience.repository;

import com.experience.data.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    // Additional query methods can be defined here, if necessary

    @Query(value = "SELECT * FROM experience WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Experience>> findByUserId(Long user_id);
}
