package com.cv.repository;

import com.cv.data.Projects;
import com.cv.data.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    // Additional query methods can be defined here, if necessary
}
