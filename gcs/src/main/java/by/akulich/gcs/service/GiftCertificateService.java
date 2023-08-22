package by.akulich.gcs.service;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.GiftCertificate;
import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.exception.GiftCertificateException;
import by.akulich.gcs.mapper.GiftCertificateMapper;
import by.akulich.gcs.repository.GiftCertificateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RequiredArgsConstructor
@Service
public class GiftCertificateService {
    private final GiftCertificateRepository giftCertificateRepository;
    private final TagService tagService;

    @Transactional
    public GiftCertificateDto addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        Optional<GiftCertificate> existedGiftCertificate = giftCertificateRepository.findByName(giftCertificateDto.getName());
        if (existedGiftCertificate.isPresent()) {
            log.error("Gift certificate with name: {} already exist", existedGiftCertificate);
            throw new GiftCertificateException("Gift certificate with name: " + existedGiftCertificate + "already exist", BAD_REQUEST);
        }

        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setName(giftCertificateDto.getName());
        giftCertificate.setDescription(giftCertificateDto.getDescription());
        giftCertificate.setPrice(giftCertificateDto.getPrice());
        giftCertificate.setDuration(giftCertificateDto.getDuration());
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());

        for (TagDto tagDto : giftCertificateDto.getTags()) {
            Tag tag = new Tag();
            if (!tagService.isTagExistByName(tagDto.getTagName())) {
                tag = new Tag();
                tag.setName(tagDto.getTagName());
                tagService.saveTag(tag);
            }
            giftCertificate.getTags().add(tag);
        }

        giftCertificateRepository.save(giftCertificate);

        return GiftCertificateMapper.INSTANCE.giftCertificateToGiftCertificateDto(giftCertificate);
    }
}
