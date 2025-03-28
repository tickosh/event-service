package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.ConcertEventDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.dto.response.MovieEventDTO;
import kz.tickosh.event.dto.response.TheatreEventDTO;
import kz.tickosh.event.model.Event;
import kz.tickosh.event.model.events.ConcertEvent;
import kz.tickosh.event.model.events.MovieEvent;
import kz.tickosh.event.model.events.TheatreEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = GlobalMapperConfig.class)
public interface EventMapper {
    @Mapping(source = "eventType", target = "eventType")
    EventDTO toDto(Event event);
    MovieEventDTO toMovieEventDto(MovieEvent movieEvent);
    ConcertEventDTO toConcertEventDto(ConcertEvent concertEvent);
    TheatreEventDTO toTheatreEventDto(TheatreEvent theatreEvent);

    Event toEntity(CreateEventRequestDTO eventCreateDto);
    MovieEvent toMovieEvent(CreateEventRequestDTO movieEventCreateDto);
    ConcertEvent toConcertEvent(CreateEventRequestDTO concertEventCreateDto);
    TheatreEvent toTheatreEvent(CreateEventRequestDTO theatreEventCreateDto);

    Event partialUpdate(CreateEventRequestDTO eventDto, @MappingTarget Event event);
    MovieEvent partialUpdate(CreateEventRequestDTO movieEventCreateDto, @MappingTarget MovieEvent movieEvent);
    ConcertEvent partialUpdate(CreateEventRequestDTO concertEventCreateDto, @MappingTarget ConcertEvent concertEvent);
    TheatreEvent partialUpdate(CreateEventRequestDTO theatreEventCreateDto, @MappingTarget TheatreEvent theatreEvent);
}