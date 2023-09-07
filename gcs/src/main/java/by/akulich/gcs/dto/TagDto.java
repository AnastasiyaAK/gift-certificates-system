package by.akulich.gcs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDto {

    private String id;

    @NotBlank(message="Name must be specified.")
    private String name;

}
