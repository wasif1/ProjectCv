package com.reviews.repository;

import com.reviews.data.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    // Additional query methods can be defined here, if necessary
}
