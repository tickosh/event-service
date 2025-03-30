package kz.tickosh.event.dto.response;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link kz.tickosh.event.model.event.EventInfoType}
 */
@Value
public class EventInfoTypeDTO implements Serializable {
    Long id;
    String nameKz;
    String nameRu;
    String nameEn;
    EventTypeDTO eventType;
    String dataType;
    String prefix;
}