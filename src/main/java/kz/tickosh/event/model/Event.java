package kz.tickosh.event.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "events")
@Getter
@Setter
public class Event extends BaseEntity {
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private String price;
}
