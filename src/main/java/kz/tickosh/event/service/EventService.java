package kz.tickosh.event.service;

import kz.tickosh.event.dto.EventDto;
import kz.tickosh.event.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getEvents();
    void createEvent(EventDto event);
    void updateEvent(Long id, EventDto event);
    void deleteEvent(Long id);
}
