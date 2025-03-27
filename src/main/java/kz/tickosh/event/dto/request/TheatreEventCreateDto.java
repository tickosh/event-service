package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TheatreEventCreateDto extends EventCreateDto {
    @NotNull
    private LocalDate releaseDateTheatre;
    @NotNull
    private Integer durationTheatre;
    private String directorTheatre;
}
