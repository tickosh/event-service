package kz.tickosh.event.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateEventRequestDTO {
    @NotBlank(message = "Event name cannot be blank.")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotBlank(message = "Age restriction is required.")
    private String ageRestriction;

    @NotBlank(message = "Event type is required.")
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



