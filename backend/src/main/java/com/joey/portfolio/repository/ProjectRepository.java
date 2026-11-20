package com.joey.portfolio.repository;

import com.joey.portfolio.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
   
}
