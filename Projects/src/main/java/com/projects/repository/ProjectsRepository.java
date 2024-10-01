package com.projects.repository;

import com.projects.data.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    // Additional query methods can be defined here, if necessary

    @Query(value = "SELECT * FROM projects WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Projects>> findByUserId(Long user_id);
}
