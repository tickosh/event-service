package kz.tickosh.event.service;

import kz.tickosh.event.dto.EventDto;
import kz.tickosh.event.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    Page<EventDto> getEvents(Pageable pageable);
    EventDto getEventById(Long id);
    void createEvent(EventDto event);
    void updateEvent(Long id, EventDto event);
    void deleteEvent(Long id);
}
