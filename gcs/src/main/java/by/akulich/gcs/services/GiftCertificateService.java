package by.akulich.gcs.services;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entities.GiftCertificate;
import by.akulich.gcs.entities.Tag;
import by.akulich.gcs.repositories.GiftCertificateRepository;
import by.akulich.gcs.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GiftCertificateService {
    private final Set<GiftCertificate> giftCertificates = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();
    private GiftCertificateRepository giftCertificateRepository;
    private TagRepository tagRepository;

    @Autowired
    public GiftCertificateService(GiftCertificateRepository giftCertificateRepository, TagRepository tagRepository) {
        this.giftCertificateRepository = giftCertificateRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public GiftCertificate addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        GiftCertificate existingCertificate = giftCertificateRepository.findByName(giftCertificateDto.getName());
        if (existingCertificate != null) {
            return null;
        }

        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setName(giftCertificateDto.getName());
        giftCertificate.setDescription(giftCertificateDto.getDescription());
        giftCertificate.setPrice(giftCertificateDto.getPrice());
        giftCertificate.setDuration(giftCertificateDto.getDuration());
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());

        for (TagDto tagDto : giftCertificateDto.getTags()) {
            Tag existingTag = tagRepository.findByName(tagDto.getName());
            Tag tag;
            if (existingTag != null) {
                tag = existingTag;
            } else {
                tag = new Tag();
                tag.setName(tagDto.getName());
                tag = tagRepository.save(tag);
            }
            giftCertificate.getTags().add(tag);
        }

        giftCertificateRepository.save(giftCertificate);

        return giftCertificate;
    }
}
