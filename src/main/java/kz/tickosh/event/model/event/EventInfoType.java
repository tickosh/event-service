package kz.tickosh.event.model.event;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kz.tickosh.event.model.DictionaryParentClass;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "event_info_types")
public class EventInfoType extends DictionaryParentClass {
    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    private String dataType;
    private String prefix;
}