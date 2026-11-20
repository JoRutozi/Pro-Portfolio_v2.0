package com.joey.portfolio.model;

import java.util.List;

public record Project(
    Long id,
    String title,
    String description,
    List<String> technologies,
    String githubUrl,
    String liveUrl,
    String imageUrl
) { 
}
