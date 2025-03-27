package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.request.ConcertEventCreateDto;
import kz.tickosh.event.dto.request.EventCreateDto;
import kz.tickosh.event.dto.request.MovieEventCreateDto;
import kz.tickosh.event.dto.request.TheatreEventCreateDto;
import kz.tickosh.event.dto.response.ConcertEventDto;
import kz.tickosh.event.dto.response.EventDto;
import kz.tickosh.event.dto.response.MovieEventDto;
import kz.tickosh.event.dto.response.TheatreEventDto;
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
    EventDto toDto(Event event);

    MovieEventDto toMovieEventDto(MovieEvent movieEvent);

    ConcertEventDto toConcertEventDto(ConcertEvent concertEvent);

    TheatreEventDto toTheatreEventDto(TheatreEvent theatreEvent);

    Event toEntity(EventCreateDto eventCreateDto);

    MovieEvent toMovieEvent(MovieEventCreateDto movieEventCreateDto);

    ConcertEvent toConcertEvent(ConcertEventCreateDto concertEventCreateDto);

    TheatreEvent toTheatreEvent(TheatreEventCreateDto theatreEventCreateDto);

    Event partialUpdate(EventDto eventDto, @MappingTarget Event event);

    MovieEvent partialUpdate(MovieEventCreateDto movieEventCreateDto, @MappingTarget MovieEvent movieEvent);

    ConcertEvent partialUpdate(ConcertEventCreateDto concertEventCreateDto, @MappingTarget ConcertEvent concertEvent);

    TheatreEvent partialUpdate(TheatreEventCreateDto theatreEventCreateDto, @MappingTarget TheatreEvent theatreEvent);
}