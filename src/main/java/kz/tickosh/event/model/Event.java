package kz.tickosh.event.model;

import jakarta.persistence.*;
import kz.tickosh.event.enums.EventType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "events")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "event_type")
public class Event extends BaseEntity {
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String location;
    private String ageRestriction;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
}

