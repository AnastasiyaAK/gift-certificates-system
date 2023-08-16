package by.akulich.gcs.services;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entities.GiftCertificate;
import by.akulich.gcs.entities.Tag;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GiftCertificateService {
    private final Set<GiftCertificate> giftCertificates = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();
    public GiftCertificate addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        Optional<GiftCertificate> existingCertificate = giftCertificates.stream()
                .filter(cert -> cert.getName().equals(giftCertificateDto.getName()))
                .findFirst();
        if (existingCertificate.isPresent()) {
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
            Optional<Tag> existingTag = tags.stream()
                    .filter(tag -> tag.getName().equals(tagDto.getName()))
                    .findFirst();
            if (existingTag.isPresent()) {
                giftCertificate.getTags().add(existingTag.get());
            } else {
                Tag newTag = new Tag();
                newTag.setName(tagDto.getName());
                tags.add(newTag);
                giftCertificate.getTags().add(newTag);
            }
        }

        giftCertificates.add(giftCertificate);
        return giftCertificate;
    }
}
