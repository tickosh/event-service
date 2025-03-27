package kz.tickosh.event.dto.response;

import jakarta.validation.constraints.NotNull;
import kz.tickosh.event.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link kz.tickosh.event.model.events.MovieEvent}
 */
@Getter
@Setter
public class MovieEventDto extends EventDto implements Serializable  {
    @NotNull
    List<String> genres;
    String director;
    List<String> actors;
    @NotNull
    LocalDate releaseDate;
    @NotNull
    Integer duration;
    @NotNull
    Language language;
    @NotNull
    String productionCountry;
    @NotNull
    Integer productionYear;
}