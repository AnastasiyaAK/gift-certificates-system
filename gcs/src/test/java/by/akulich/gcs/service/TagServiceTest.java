package by.akulich.gcs.service;

import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.repository.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class TagServiceTest {

    private TagService tagService;

    @Mock
    private TagRepository tagRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tagService = new TagService(tagRepository);
    }

    @Test
    public void testGetTagByName_WhenTagExists() {
        String tagName = "TestTag";
        Tag expectedTag = new Tag();
        expectedTag.setName(tagName);
        when(tagRepository.findByName(tagName)).thenReturn(Optional.of(expectedTag));

        Optional<Tag> result = tagService.getTagByName(tagName);

        Assertions.assertEquals(Optional.of(expectedTag), result);
    }

    @Test
    public void testGetTagByName_WhenTagDoesNotExist() {
        String tagName = "NonExistentTag";
        when(tagRepository.findByName(tagName)).thenReturn(Optional.empty());

        Optional<Tag> result = tagService.getTagByName(tagName);

        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    public void testSaveTag() {
        Tag tagToSave = new Tag();
        tagToSave.setName("NewTag");

        tagService.saveTag(tagToSave);

        verify(tagRepository, times(1)).save(tagToSave);
    }
}