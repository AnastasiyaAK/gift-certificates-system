package by.akulich.gcs.service;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.GiftCertificate;
import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.exception.GiftCertificateException;
import by.akulich.gcs.mapper.GiftCertificateMapper;
import by.akulich.gcs.mapper.TagMapper;
import by.akulich.gcs.repository.GiftCertificateRepository;
import by.akulich.gcs.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RequiredArgsConstructor
@Service
public class GiftCertificateService {

    private final GiftCertificateMapper mapper = Mappers.getMapper(GiftCertificateMapper.class);
    private final TagMapper mapperTag = Mappers.getMapper(TagMapper.class);
    private final GiftCertificateRepository giftCertificateRepository;
    private final TagService tagService;

    @Transactional
    public GiftCertificateDto addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        Optional<GiftCertificate> existedGiftCertificate = giftCertificateRepository.findByName(giftCertificateDto.getName());
        if (existedGiftCertificate.isPresent()) {
            log.error("Gift certificate with name: {} already exist", existedGiftCertificate);
            throw new GiftCertificateException("Gift certificate with name: " + existedGiftCertificate + "already exist", BAD_REQUEST);
        }


        GiftCertificate giftCertificate = mapper.giftCertificateDtoToGiftCertificate(giftCertificateDto);
        System.out.println("GIFT CERT " + giftCertificate);

        for (Tag tag : giftCertificate.getTags()) {
            String tagName = tag.getName();

            if (tagService.getTagByName(tagName).isEmpty()) {
                System.out.println("TAG" + tag);
                tagService.saveTag(tag);
            }
        }

        giftCertificateRepository.save(giftCertificate);

        return mapper.giftCertificateToGiftCertificateDto(giftCertificate);
    }

}
