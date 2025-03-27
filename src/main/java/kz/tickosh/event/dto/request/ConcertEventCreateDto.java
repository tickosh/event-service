package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ConcertEventCreateDto extends EventCreateDto {
    @NotNull
    private LocalDateTime startTime;
    private String concertDuration;
    private List<String> artists;
}
