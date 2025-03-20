package kz.tickosh.event.service.impl;

import kz.tickosh.event.dto.EventDto;
import kz.tickosh.event.model.Event;
import kz.tickosh.event.repository.EventRepository;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;


    @Override
    public List<Event> getEvents() {
        return List.of();
    }

    @Override
    public void createEvent(EventDto event) {

    }

    @Override
    public void updateEvent(Long id, EventDto event) {

    }

    @Override
    public void deleteEvent(Long id) {

    }
}
