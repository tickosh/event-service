package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kz.tickosh.event.enums.EventType;
import kz.tickosh.event.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateEventRequestDTO {
    @NotBlank(message = "Event name cannot be blank.")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotBlank(message = "Age restriction is required.")
    private String ageRestriction;

    @NotBlank(message = "Event type is required.")
    private EventType eventType;

    private LocalDateTime startTime;
    private String duration;
    private List<String> artists;
    private List<String> genres;
    private String director;
    private List<String> actors;
    private LocalDate releaseDate;
    private Integer durationMinutes;
    private Language language;
    private String productionCountry;
    private Integer productionYear;
}

