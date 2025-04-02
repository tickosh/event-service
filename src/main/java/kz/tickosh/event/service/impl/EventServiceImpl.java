package kz.tickosh.event.service.impl;

import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.dto.response.EventDetailDTO;
import kz.tickosh.event.mapper.EventInfoMapper;
import kz.tickosh.event.mapper.EventInfoTypeMapper;
import kz.tickosh.event.mapper.EventMapper;
import kz.tickosh.event.mapper.EventTypeMapper;
import kz.tickosh.event.model.event.Event;
import kz.tickosh.event.model.event.EventInfo;
import kz.tickosh.event.model.event.EventType;
import kz.tickosh.event.repository.event.EventInfoRepository;
import kz.tickosh.event.repository.event.EventInfoTypeRepository;
import kz.tickosh.event.repository.event.EventRepository;
import kz.tickosh.event.repository.event.EventTypeRepository;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventTypeRepository eventTypeRepository;
    private final EventInfoRepository eventInfoRepository;
    private final EventInfoTypeRepository eventInfoTypeRepository;

    private final EventMapper eventMapper;
    private final EventTypeMapper eventTypeMapper;
    private final EventInfoMapper eventInfoMapper;
    private final EventInfoTypeMapper eventInfoTypeMapper;

    @Override
    public Page<EventDTO> getEvents(Pageable pageable, Long typeId) {
        if (typeId != null) {
            EventType eventType = eventTypeRepository.findById(typeId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid event type ID"));
            return eventRepository.findByEventType(pageable, eventType)
                    .map(eventMapper::toDto);
        } else {
            return eventRepository.findAll(pageable)
                    .map(eventMapper::toDto);
        }
    }

    @Override
    public EventDetailDTO getEventById(Long id) {
        Event event = eventRepository.findEventById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        List<EventInfo> eventInfos = eventInfoRepository.findEventInfoByEvent(event);

        return eventMapper.toDetailDto(event, eventInfos);
    }

    @Override
    public void createEvent(CreateEventRequestDTO eventRequest) {
        EventType eventType = eventTypeRepository.findById(eventRequest.getEventTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid event type ID"));

        Event event = eventMapper.toEntity(eventRequest, eventType);
        eventRepository.save(event);

        manipulateEventInfo(eventRequest, event);
    }

    @Override
    public void updateEvent(Long id, CreateEventRequestDTO eventRequest) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        EventType eventType = eventTypeRepository.findById(eventRequest.getEventTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid event type ID"));

        eventMapper.partialUpdate(eventRequest, event, eventType);
        eventRepository.save(event);

        manipulateEventInfo(eventRequest, event);
    }

    private void manipulateEventInfo(CreateEventRequestDTO eventRequest, Event event) {
        for (CreateEventRequestDTO.CreateEventInfoRequestDTO eventInfoRequest : eventRequest.getEventInfos()) {
            EventInfo eventInfo = new EventInfo();

            if(eventInfoRequest.getId() != null) {
                eventInfo = eventInfoRepository.findById(eventInfoRequest.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid event info ID"));
            }

            eventInfo.setEvent(event);
            eventInfo.setEventInfoType(eventInfoTypeRepository.findById(eventInfoRequest.getEventInfoTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid event info type ID")));
            eventInfo.setValue(eventInfoRequest.getValue());
            eventInfoRepository.save(eventInfo);
        }
    }

    @Override
    public void deleteEvent(Long id) {
        if(eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }
}
