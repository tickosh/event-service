package kz.tickosh.event.model.events;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import kz.tickosh.event.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("CONCERT")
@Table(name = "concert_events")
public class ConcertEvent extends Event {
    @NotNull
    private LocalDateTime startTime;

    private String duration;

    @ElementCollection
    private List<String> artists;
}
