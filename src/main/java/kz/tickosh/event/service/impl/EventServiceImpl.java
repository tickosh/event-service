package kz.tickosh.event.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.enums.EventType;
import kz.tickosh.event.exception.NotFoundException;
import kz.tickosh.event.mapper.EventMapper;
import kz.tickosh.event.model.Event;
import kz.tickosh.event.model.events.ConcertEvent;
import kz.tickosh.event.model.events.MovieEvent;
import kz.tickosh.event.model.events.TheatreEvent;
import kz.tickosh.event.repository.EventRepository;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    private final EventMapper eventMapper;


    @Override
    public Page<Object> getEvents(Pageable pageable, String type) {
        return eventRepository.findByEventType(pageable, EventType.valueOf(type)).map(eventMapper::toDto);
    }

    @Override
    public EventDTO getEventById(Long id) {
        return eventMapper.toDto(eventRepository.findEventById(id).orElseThrow(() -> new NotFoundException("Event not found by id: " + id)));
    }

    @Override
    public Event createEvent(CreateEventRequestDTO createEventRequestDTO) {
        Event event = switch (createEventRequestDTO.getEventType()) {
            case MOVIE -> eventMapper.toMovieEvent(createEventRequestDTO);  // Map DTO to MovieEvent
            case CONCERT -> eventMapper.toConcertEvent(createEventRequestDTO);
            case THEATRE -> eventMapper.toTheatreEvent(createEventRequestDTO);
            default -> throw new IllegalArgumentException("Unsupported event type");
        };

        event.setName(createEventRequestDTO.getName());
        event.setDescription(createEventRequestDTO.getDescription());
        event.setLocation(createEventRequestDTO.getLocation());
        event.setAgeRestriction(createEventRequestDTO.getAgeRestriction());

        return eventRepository.save(event);
    }

    @Override
    public void updateEvent(Long id, CreateEventRequestDTO updateEventRequestDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        event = switch (updateEventRequestDTO.getEventType()) {
            case MOVIE -> eventMapper.partialUpdate(updateEventRequestDTO, (MovieEvent) event);
            case CONCERT -> eventMapper.partialUpdate(updateEventRequestDTO, (ConcertEvent) event);
            case THEATRE -> eventMapper.partialUpdate(updateEventRequestDTO, (TheatreEvent) event);
            default -> throw new IllegalArgumentException("Unsupported event type");
        };

        eventRepository.save(event);
    }


    @Override
    public void deleteEvent(Long id) {
        if(!eventRepository.existsById(id)){
            throw new NotFoundException("Event not found by id: " + id);
        }

        eventRepository.deleteById(id);
    }
}
