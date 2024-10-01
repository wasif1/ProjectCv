package com.reviews.repository;

import com.reviews.data.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    // Additional query methods can be defined here, if necessary

    @Query(value = "SELECT * FROM reviews WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Reviews>> findByUserId(Long user_id);
}
