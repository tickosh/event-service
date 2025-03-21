package kz.tickosh.event.service;

import kz.tickosh.event.dto.EventDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {
    Page<EventDto> getEvents(Pageable pageable);
    EventDto getEventById(Long id);
    void createEvent(EventDto event);
    void updateEvent(Long id, EventDto event);
    void deleteEvent(Long id);
}
