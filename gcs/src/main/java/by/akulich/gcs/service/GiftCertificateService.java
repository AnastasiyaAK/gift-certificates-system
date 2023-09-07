package by.akulich.gcs.service;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.entity.GiftCertificate;
import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.exception.GiftCertificateException;
import by.akulich.gcs.mapper.GiftCertificateMapper;
import by.akulich.gcs.repository.GiftCertificateRepository;
import by.akulich.gcs.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RequiredArgsConstructor
@Service
public class GiftCertificateService {

    private final GiftCertificateMapper mapper;
    private final GiftCertificateRepository giftCertificateRepository;
    private final TagService tagService;

    @Transactional
    public GiftCertificateDto addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        log.debug("Create certificate with name: {} ", giftCertificateDto.getName());
        Optional<GiftCertificate> existedGiftCertificate = giftCertificateRepository.findByName(giftCertificateDto.getName());
        if (existedGiftCertificate.isPresent()) {
            log.error("Gift certificate with name: {} already exist", existedGiftCertificate);
            throw new GiftCertificateException("Gift certificate with name: " + existedGiftCertificate + "already exist", BAD_REQUEST, ErrorCode.GIFT_CERTIFICATE_ALREADY_EXIST);
        }

        GiftCertificate giftCertificate = mapper.toGiftCertificate(giftCertificateDto);

        for (Tag tag : giftCertificate.getTags()) {
            String tagName = tag.getName();
            if (tagService.getTagByName(tagName).isEmpty()) {
                log.debug("Save tag with name {}", tagName);
                tagService.saveTag(tag);
            }
        }

        giftCertificateRepository.save(giftCertificate);

        return mapper.toGiftCertificateDto(giftCertificate);
    }

}
