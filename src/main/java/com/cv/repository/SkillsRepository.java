package com.cv.repository;

import com.cv.data.Services;
import com.cv.data.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    // Additional query methods can be defined here, if necessary
}
