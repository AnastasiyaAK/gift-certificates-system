package by.akulich.gcs.mapper;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.entity.GiftCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiftCertificateMapper {

    GiftCertificateMapper INSTANCE = Mappers.getMapper(GiftCertificateMapper.class);

    @Mapping(target="id", source="entity.id")
    @Mapping(target="name", source="entity.name")
    @Mapping(target="description", source="entity.description")
    @Mapping(target="price", source="entity.price")
    @Mapping(target="duration", source="entity.duration")
    @Mapping(target="createDate", source="entity.createDate")
    @Mapping(target="lastUpdateDate", source="entity.lastUpdateDate")
    @Mapping(target="tags", source="entity.tags")
    GiftCertificateDto giftCertificateToGiftCertificateDto(GiftCertificate entity);

    @Mapping(target="id", source="dto.id")
    @Mapping(target="name", source="dto.name")
    @Mapping(target="description", source="dto.description")
    @Mapping(target="price", source="dto.price")
    @Mapping(target="duration", source="dto.duration")
    @Mapping(target="createDate", source="dto.createDate")
    @Mapping(target="lastUpdateDate", source="dto.lastUpdateDate")
    @Mapping(target="tags", source="dto.tags")
    GiftCertificate giftCertificateDtoToGiftCertificate(GiftCertificateDto dto);

}
