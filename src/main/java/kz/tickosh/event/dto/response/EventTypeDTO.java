package kz.tickosh.event.dto.response;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kz.tickosh.event.model.event.EventType}
 */
@Value
public class EventTypeDTO implements Serializable {
    Long id;
    String nameKz;
    String nameRu;
    String nameEn;
}