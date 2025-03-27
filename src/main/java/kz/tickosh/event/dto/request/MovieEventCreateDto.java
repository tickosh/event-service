package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotNull;
import kz.tickosh.event.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieEventCreateDto extends EventCreateDto {
    @NotNull
    private List<String> genres;
    private String director;
    private List<String> actors;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private Integer duration;
    @NotNull
    private Language language;
    @NotNull
    private String productionCountry;
    @NotNull
    private Integer productionYear;
}
