package kz.tickosh.event.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link kz.tickosh.event.model.events.TheatreEvent}
 */
@Getter
@Setter
public class TheatreEventDTO extends EventDTO implements Serializable {
    @NotNull
    LocalDate releaseDate;
    @NotNull
    Integer duration;
    @NotNull
    String director;
}