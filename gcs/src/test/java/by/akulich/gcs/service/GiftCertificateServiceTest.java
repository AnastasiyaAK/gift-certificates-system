package by.akulich.gcs.service;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.dto.TagDto;
import by.akulich.gcs.entity.GiftCertificate;
import by.akulich.gcs.entity.Tag;
import by.akulich.gcs.exception.GiftCertificateException;
import by.akulich.gcs.mapper.GiftCertificateMapper;
import by.akulich.gcs.repository.GiftCertificateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

public class GiftCertificateServiceTest {

    private GiftCertificateService giftCertificateService;

    @Mock
    private GiftCertificateMapper mapper;

    @Mock
    private GiftCertificateRepository giftCertificateRepository;

    @Mock
    private TagService tagService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        giftCertificateService = new GiftCertificateService(mapper, giftCertificateRepository, tagService);
    }

    @Test
    @Transactional
    public void testAddGiftCertificate_Success() {

    }

    @Test
    @Transactional
    public void testAddGiftCertificate_DuplicateCertificateName() {
        GiftCertificateDto giftCertificateDto = new GiftCertificateDto();
        giftCertificateDto.setName("ExistingCertificate");

        when(giftCertificateRepository.findByName("ExistingCertificate"))
                .thenReturn(Optional.of(new GiftCertificate()));

        Assertions.assertThrows(GiftCertificateException.class, () -> giftCertificateService.addGiftCertificate(giftCertificateDto));
    }
}

