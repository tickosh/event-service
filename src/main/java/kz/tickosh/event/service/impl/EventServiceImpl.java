package kz.tickosh.event.service.impl;

import kz.tickosh.event.dto.EventDto;
import kz.tickosh.event.exception.NotFoundException;
import kz.tickosh.event.mapper.EventMapper;
import kz.tickosh.event.model.Event;
import kz.tickosh.event.repository.EventRepository;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    private final EventMapper eventMapper;


    @Override
    public Page<EventDto> getEvents(Pageable pageable) {
        return eventRepository.findAll(pageable).map(eventMapper::toDto);
    }

    @Override
    public EventDto getEventById(Long id) {
        return eventMapper.toDto(eventRepository.findEventById(id).orElseThrow(() -> new NotFoundException("Event not found by id: " + id)));
    }

    @Override
    public void createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Long id, EventDto eventDto) {
        Event event = eventRepository.findEventById(id)
                .orElseThrow(() -> new NotFoundException("Event not found by id: " + id));
        eventRepository.save(eventMapper.partialUpdate(eventDto, event));
    }

    @Override
    public void deleteEvent(Long id) {
        if(!eventRepository.existsById(id)){
            throw new NotFoundException("Event not found by id: " + id);
        }

        eventRepository.deleteById(id);
    }
}
