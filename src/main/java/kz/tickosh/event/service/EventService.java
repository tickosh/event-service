package kz.tickosh.event.service;

import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.dto.response.EventDetailDTO;
import kz.tickosh.event.dto.response.EventInfoTypeDTO;
import kz.tickosh.event.dto.response.EventTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    Page<EventDTO> getEvents(Pageable pageable, Long typeId);
    EventDetailDTO getEventById(Long id);
    List<EventTypeDTO> getEventTypes();
    List<EventInfoTypeDTO> getEventTypesInfo(Long typeId);
    void createEvent(CreateEventRequestDTO event);
    void updateEvent(Long id, CreateEventRequestDTO event);
    void deleteEvent(Long id);
}