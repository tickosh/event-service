package kz.tickosh.event.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link kz.tickosh.event.model.Event}
 */
@Value
public class EventDto implements Serializable {
    Long id;

    @NotBlank(message = "Event name cannot be blank.")
    String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    String description;

    @NotBlank(message = "Location is required.")
    String location;

    @Future(message = "Event date must be in the future.")
    LocalDateTime dateTime;

    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Price must be a valid monetary amount.")
    String price;
}