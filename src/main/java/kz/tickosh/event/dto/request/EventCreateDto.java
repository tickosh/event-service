package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kz.tickosh.event.enums.EventType;

public class EventCreateDto {
    @NotBlank(message = "Event name cannot be blank.")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotBlank(message = "Age restriction is required.")
    private String ageRestriction;

    @NotBlank(message = "Event type is required.")
    private EventType eventType;  // EventType (MOVIE, CONCERT, THEATRE)
}

