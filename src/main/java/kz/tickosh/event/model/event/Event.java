package kz.tickosh.event.model.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kz.tickosh.event.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "events")
@Getter
@Setter
public class Event extends BaseEntity {
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String location;
    private String ageRestriction;

    @ManyToOne
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventType eventType;
}

