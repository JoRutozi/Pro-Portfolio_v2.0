package com.joey.portfolio.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")

public class ProjectEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @ElementCollection
    @CollectionTable(
        name = "project_technologies", 
        joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "technology", nullable = false)
    private List<String> technologies = new ArrayList<>();

    // Getters and Setters
    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "live_url")
    private String liveUrl;

    @Column(name = "image_url")
    private String imageUrl;

    protected ProjectEntity() {
    }

    public ProjectEntity(
        String title,
        String description,
        List<String> technologies,
        String githubUrl,
        String liveUrl,
        String imageUrl
    ){
        this.title = title;
        this.description = description;
        this.technologies = new ArrayList<>(technologies);
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
        this.imageUrl = imageUrl;
    }

    public void update(
    String title,
    String description,
    List<String> technologies,
    String githubUrl,
    String liveUrl,
    String imageUrl
    ){
    this.title = title;
    this.description = description;
    this.technologies = new ArrayList<>(technologies);
    this.githubUrl = githubUrl;
    this.liveUrl = liveUrl;
    this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
