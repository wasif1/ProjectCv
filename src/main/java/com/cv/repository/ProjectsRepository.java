package com.cv.repository;

import com.cv.data.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    // Additional query methods can be defined here, if necessary
}
