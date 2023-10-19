package dev.microservice.restapi.model;

import java.time.LocalDateTime;

public record Content(
    Integer id,
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dateCreate,
    LocalDateTime dateUpdate,
    String url
) {
    
}
