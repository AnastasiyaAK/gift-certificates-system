package by.akulich.gcs.service;

import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagService {

    private final TagRepository tagRepository;

    public Optional<Tag> getTagByName(String name) {
        return tagRepository.findByName(name);

    }

    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

}
