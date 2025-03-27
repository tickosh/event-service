package kz.tickosh.event.model.events;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.DiscriminatorValue;
import jakarta.validation.constraints.NotNull;
import kz.tickosh.event.enums.Language;
import kz.tickosh.event.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("MOVIE")
public class MovieEvent extends Event {

    @ElementCollection
    @NotNull
    private List<String> genres;

    private String director;

    @ElementCollection
    private List<String> actors;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Integer duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;

    @NotNull
    private String productionCountry;

    @NotNull
    private Integer productionYear;
}
