package kz.tickosh.event.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link kz.tickosh.event.model.events.ConcertEvent}
 */
@Getter
@Setter
public class ConcertEventDTO extends EventDTO implements Serializable {
    @NotNull
    LocalDateTime startTime;
    String duration;
    List<String> artists;
}