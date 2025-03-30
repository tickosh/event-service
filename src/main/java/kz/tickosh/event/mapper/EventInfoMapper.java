package kz.tickosh.event.mapper;

import kz.tickosh.event.config.GlobalMapperConfig;
import kz.tickosh.event.dto.response.EventInfoDTO;
import kz.tickosh.event.model.event.EventInfo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = GlobalMapperConfig.class, uses = {EventInfoTypeMapper.class})
public interface EventInfoMapper {
    EventInfoDTO toDto(EventInfo eventInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventInfo partialUpdate(EventInfoDTO eventInfoDto, @MappingTarget EventInfo eventInfo);
}