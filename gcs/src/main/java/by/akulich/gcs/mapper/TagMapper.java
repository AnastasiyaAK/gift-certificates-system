package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target="tagId", source="entity.id")
    @Mapping(target="tagName", source="entity.name")
    TagDto tagToTagDto(Tag entity);

    @Mapping(target="id", source="dto.tagId")
    @Mapping(target="name", source="dto.tagName")
    Tag tagDtoToTag(TagDto dto);

}
