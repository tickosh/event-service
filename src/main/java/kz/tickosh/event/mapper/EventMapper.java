package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.EventDto;
import kz.tickosh.event.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = GlobalMapperConfig.class)
public interface EventMapper {
    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);

    Event partialUpdate(EventDto eventDto, @MappingTarget Event event);
}