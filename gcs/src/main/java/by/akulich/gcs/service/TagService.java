package by.akulich.gcs.service;

import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TagService {
    private final TagRepository tagRepository;

    public boolean isTagExistByName(String name) {
        return tagRepository.findByName(name).isPresent();
    }

    @Transactional
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }
}
