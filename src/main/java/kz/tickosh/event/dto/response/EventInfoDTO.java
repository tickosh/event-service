package kz.tickosh.event.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kz.tickosh.event.model.event.EventInfo}
 */
@Value
public class EventInfoDTO implements Serializable {
    Long id;

    @NotNull
    EventInfoTypeDTO eventInfoType;

    @NotNull
    @NotEmpty
    @NotBlank
    String value;
}