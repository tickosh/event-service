package kz.tickosh.event.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link kz.tickosh.event.model.Event}
 */
@Value
public class EventDto implements Serializable {
    String name;
    String description;
    String location;
    LocalDateTime dateTime;
    String price;
}