package com.skills.repository;

import com.skills.data.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    // Additional query methods can be defined here, if necessary

    @Query(value = "SELECT * FROM skills WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Skills>> findByUserId(Long user_id);
}
