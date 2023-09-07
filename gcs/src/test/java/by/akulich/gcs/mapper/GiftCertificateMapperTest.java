package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.entity.GiftCertificate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

public class GiftCertificateMapperTest {

    private GiftCertificateMapper giftCertificateMapper = Mappers.getMapper(GiftCertificateMapper.class);

    @Test
    public void testToGiftCertificate() {
        GiftCertificateDto giftCertificateDto = new GiftCertificateDto();
        giftCertificateDto.setId("testId");
        giftCertificateDto.setName("testName");
        giftCertificateDto.setDescription("testDescription");
        giftCertificateDto.setPrice(BigDecimal.valueOf(10.99));
        giftCertificateDto.setDuration(7);

        GiftCertificate giftCertificate = giftCertificateMapper.toGiftCertificate(giftCertificateDto);

        Assertions.assertEquals(giftCertificateDto.getId(), giftCertificate.getId());
        Assertions.assertEquals(giftCertificateDto.getName(), giftCertificate.getName());
        Assertions.assertEquals(giftCertificateDto.getDescription(), giftCertificate.getDescription());
        Assertions.assertEquals(giftCertificateDto.getPrice(), giftCertificate.getPrice());
        Assertions.assertEquals(giftCertificateDto.getDuration(), giftCertificate.getDuration());
    }

    @Test
    public void testToGiftCertificateDto() {
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId("testId");
        giftCertificate.setName("testName");
        giftCertificate.setDescription("testDescription");
        giftCertificate.setPrice(BigDecimal.valueOf(10.99));
        giftCertificate.setDuration(7);

        GiftCertificateDto giftCertificateDto = giftCertificateMapper.toGiftCertificateDto(giftCertificate);

        Assertions.assertEquals(giftCertificate.getId(), giftCertificateDto.getId());
        Assertions.assertEquals(giftCertificate.getName(), giftCertificateDto.getName());
        Assertions.assertEquals(giftCertificate.getDescription(), giftCertificateDto.getDescription());
        Assertions.assertEquals(giftCertificate.getPrice(), giftCertificateDto.getPrice());
        Assertions.assertEquals(giftCertificate.getDuration(), giftCertificateDto.getDuration());}

}
