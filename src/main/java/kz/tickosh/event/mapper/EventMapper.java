package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.dto.response.EventDetailDTO;
import kz.tickosh.event.model.event.Event;
import kz.tickosh.event.model.event.EventInfo;
import kz.tickosh.event.model.event.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = GlobalMapperConfig.class, uses = {EventTypeMapper.class, EventInfoMapper.class})
public interface EventMapper {
    EventDTO toDto(Event event);

    @Mapping(target = "eventInfos", source = "eventInfo")
    EventDetailDTO toDetailDto(Event event, List<EventInfo> eventInfo);
    Event toEntity(CreateEventRequestDTO eventCreateDto, EventType eventType);
    Event partialUpdate(CreateEventRequestDTO eventDto, @MappingTarget Event event, EventType eventType);
}