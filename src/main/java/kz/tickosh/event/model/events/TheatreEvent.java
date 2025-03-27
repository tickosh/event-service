package kz.tickosh.event.model.events;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import kz.tickosh.event.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@DiscriminatorValue("THEATRE")
public class TheatreEvent extends Event {
    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Integer duration;

    @NotNull
    private String director;
}
