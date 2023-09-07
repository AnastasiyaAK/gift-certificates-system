package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDto toTagDto(Tag entity);

    Tag toTag(TagDto dto);

}
