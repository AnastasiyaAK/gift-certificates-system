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

        GiftCertificate giftCertificate = GiftCertificateMapper.INSTANCE.giftCertificateDtoToGiftCertificate(giftCertificateDto);
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());

        for (TagDto tagDto : giftCertificateDto.getTags()) {
            String tagName = tagDto.getTagName();
            Tag tag;
            if (tagService.getTagByName(tagName) != null) {
                tag = tagService.getTagByName(tagName);
            } else {
                tag = new Tag();
                tag.setName(tagName);
                tagService.saveTag(tag);
            }
            giftCertificate.getTags().add(tag);
        }

        giftCertificateRepository.save(giftCertificate);

        return GiftCertificateMapper.INSTANCE.giftCertificateToGiftCertificateDto(giftCertificate);
    }
}
