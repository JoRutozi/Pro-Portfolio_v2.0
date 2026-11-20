package com.joey.portfolio.config;

import com.joey.portfolio.entity.ProjectEntity;
import com.joey.portfolio.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {
    private final ProjectRepository projectRepository;

    DataInitializer(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Bean
    CommandLineRunner seedProjects(ProjectRepository projectRepository) {
        return args -> {
            if (projectRepository.count() > 0) {
                return;
            }
            projectRepository.saveAll(List.of(
                new ProjectEntity(
                    "Personal portfolio",
                    "A full-stack personal portfolio built with Angular and Spring Boot",
                    List.of("Angular", "Spring Boot", "TypeScript"),
                    null,
                    null,
                    null
                ),
                new ProjectEntity(
                    "Task management API",
                    "A RESTful API for managing tasks built with Spring Boot",
                    List.of("Backend", "Java", "Spring Boot", "PostgreSQL"),
                    null,
                    null,
                    null
                )
            ));
        };
    }
}
