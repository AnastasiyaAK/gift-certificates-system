package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.entity.GiftCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GiftCertificateMapper {

    GiftCertificateDto toGiftCertificateDto(GiftCertificate entity);

    GiftCertificate toGiftCertificate(GiftCertificateDto dto);

}
