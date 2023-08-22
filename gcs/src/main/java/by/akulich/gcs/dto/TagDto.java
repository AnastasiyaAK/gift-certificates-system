package by.akulich.gcs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TagDto {
    private UUID tagId;
    private String tagName;

}
