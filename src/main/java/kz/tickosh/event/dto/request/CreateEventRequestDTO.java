package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateEventRequestDTO {
    @NotNull(message = "Event name is required.")
    @NotBlank(message = "Event name cannot be blank.")
    private String name;

    @NotNull(message = "Description is required.")
    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotNull(message = "Location is required.")
    @NotBlank(message = "Location cannot be blank.")
    private String location;

    @NotNull(message = "Age restriction is required.")
    @NotBlank(message = "Age restriction cannot be blank.")
    @Pattern(regexp = "^[0-9]+$")
    private String ageRestriction;

    @NotNull(message = "Event type is required.")
    private Long eventTypeId;

    private List<CreateEventInfoRequestDTO> eventInfos;

    @Getter
    @Setter
    public static class CreateEventInfoRequestDTO {
        private Long id;
        private Long eventInfoTypeId;
        private String value;
    }
}



