package by.akulich.gcs.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class GiftCertificateDto {
    private String name;
    private String description;
    private BigDecimal price;
    private int duration;
    private Set<TagDto> tags;
}
