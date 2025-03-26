package kz.tickosh.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "events")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Event extends BaseEntity {
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String location;
    private String ageRestriction;
}

