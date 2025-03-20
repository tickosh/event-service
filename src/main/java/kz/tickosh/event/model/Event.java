package kz.tickosh.event.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "events")
public class Event extends BaseEntity {
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private String price;
}
