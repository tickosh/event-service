package kz.tickosh.event.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kz.tickosh.event.enums.EventType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for {@link kz.tickosh.event.model.Event}
 */
@Getter
@Setter
public class EventDto {
    Long id;

    @NotBlank(message = "Event name cannot be blank.")
    String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    String description;

    @NotBlank(message = "Location is required.")
    String location;

    @NotBlank(message = "Age restriction is required.")
    String ageRestriction;

    @NotBlank(message = "Event type is required.")
    EventType eventType;
}