package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class TagMapperTest {

    private TagMapper tagMapper = Mappers.getMapper(TagMapper.class);

    @Test
    public void testToTag() {
        TagDto tagDto = new TagDto();
        tagDto.setId("testId");
        tagDto.setName("testName");

        Tag tag = tagMapper.toTag(tagDto);

        Assertions.assertEquals(tagDto.getId(), tag.getId());
        Assertions.assertEquals(tagDto.getName(), tag.getName());
    }

    @Test
    public void testToTagDto() {
        Tag tag = new Tag();
        tag.setId("testId");
        tag.setName("testName");

        TagDto tagDto = tagMapper.toTagDto(tag);

        Assertions.assertEquals(tag.getId(), tagDto.getId());
        Assertions.assertEquals(tag.getName(), tagDto.getName());
    }

}
