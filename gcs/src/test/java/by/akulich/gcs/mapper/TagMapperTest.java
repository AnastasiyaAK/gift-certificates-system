package by.akulich.gcs.mapper;


import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TagMapperTest {

    @Test
    public void testTagDtoToTag() {

        TagDto dto = new TagDto();
        dto.setTagName("tag name");

        Tag entity = TagMapper.INSTANCE.tagDtoToTag(dto);
        Assertions.assertEquals(dto.getTagId(), entity.getId());
        Assertions.assertEquals(dto.getTagName(), entity.getName());
    }

}
