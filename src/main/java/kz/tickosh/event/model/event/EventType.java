package kz.tickosh.event.model.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.tickosh.event.model.DictionaryParentClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_type")
public class EventType extends DictionaryParentClass {
}