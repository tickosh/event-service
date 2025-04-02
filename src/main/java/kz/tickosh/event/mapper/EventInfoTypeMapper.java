package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.response.EventInfoTypeDTO;
import kz.tickosh.event.model.event.EventInfoType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = GlobalMapperConfig.class, uses = {EventTypeMapper.class})
public interface EventInfoTypeMapper {
    EventInfoTypeDTO toDto(EventInfoType eventInfoType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventInfoType partialUpdate(EventInfoTypeDTO eventInfoTypeDto, @MappingTarget EventInfoType eventInfoType);
}