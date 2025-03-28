package kz.tickosh.event.service;

import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {
    Page<Object> getEvents(Pageable pageable, String type);
    EventDTO getEventById(Long id);
    Event createEvent(CreateEventRequestDTO event);
    void updateEvent(Long id, CreateEventRequestDTO event);
    void deleteEvent(Long id);
}