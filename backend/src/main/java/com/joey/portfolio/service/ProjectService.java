package com.joey.portfolio.service;

import com.joey.portfolio.entity.ProjectEntity;
import com.joey.portfolio.model.Project;
import com.joey.portfolio.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.joey.portfolio.dto.CreateProjectRequest;

import java.util.Optional;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public List<Project> getAllProjects() {
        return projectRepository.findAll(Sort.by("id"))
        .stream()
        .map(this::toProject)
        .toList();
    }
    
    @Transactional 
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(this::toProject);
    }

    @Transactional 
    public  Optional<Project> updateProject(
        Long id,
        CreateProjectRequest request
    ) {
        return projectRepository.findById(id)
                .map(projectEntity ->{
                    projectEntity.update(
                        request.title(),
                        request.description(),
                        request.technologies(),
                        request.githubUrl(),
                        request.liveUrl(),
                        request.imageUrl()
                    );

                    return toProject(projectEntity);
                });
    }

    @Transactional 
    public boolean deleteProject(Long id) {
        return projectRepository.findById(id)
                .map(projectEntity -> {
                    projectRepository.delete(projectEntity);
                    return true;
                })
                .orElse(false);
    }

    private Project toProject(ProjectEntity projectEntity) {
        return new Project(
            projectEntity.getId(),
            projectEntity.getTitle(),
            projectEntity.getDescription(),
            List.copyOf(projectEntity.getTechnologies()),
            projectEntity.getGithubUrl(),
            projectEntity.getLiveUrl(),
            projectEntity.getImageUrl()
        );
    }

    @Transactional
    public Project createProject(CreateProjectRequest request) {
        ProjectEntity projectEntity = new ProjectEntity(
        request.title(),
        request.description(),
        request.technologies(),
        request.githubUrl(),
        request.liveUrl(),
        request.imageUrl()
        );
        ProjectEntity savedEntity = projectRepository.save(projectEntity);
        return toProject(savedEntity);
    }
}
