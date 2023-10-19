package dev.microservice.restapi.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record Content(
    Integer id,
    @NotBlank
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dateCreate,
    LocalDateTime dateUpdate,
    String url
) {
    
}
