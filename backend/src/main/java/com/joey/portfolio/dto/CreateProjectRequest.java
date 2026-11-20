package com.joey.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;


public record CreateProjectRequest (
    @NotBlank 
    @Size(max = 120)
    String title,

    @NotBlank
    @Size(max = 2000)
    String description,

    @NotEmpty
    List<@NotBlank @Size(max = 80) String> technologies,

    @Size(max = 500)
    String githubUrl,

    @Size(max = 500)
    String liveUrl,

    @Size(max = 500)
    String imageUrl
) {
}
