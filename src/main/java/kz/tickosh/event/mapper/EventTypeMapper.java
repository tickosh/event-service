package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.response.EventTypeDTO;
import kz.tickosh.event.model.event.EventType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = GlobalMapperConfig.class)
public interface EventTypeMapper {
    EventType toEntity(EventTypeDTO eventTypeDto);

    EventTypeDTO toDto(EventType eventType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventType partialUpdate(EventTypeDTO eventTypeDto, @MappingTarget EventType eventType);
}