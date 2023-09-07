package by.akulich.gcs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class GiftCertificateDto {

    private String id;

    @NotBlank(message="Name must be specified.")
    private String name;

    @NotNull
    @Max(250)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int duration;

    @NotNull
    private Set<TagDto> tags;

}
