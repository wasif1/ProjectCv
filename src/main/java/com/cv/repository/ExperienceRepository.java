package com.cv.repository;

import com.cv.data.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    // Additional query methods can be defined here, if necessary
}
