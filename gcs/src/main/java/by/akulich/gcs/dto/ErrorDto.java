package by.akulich.gcs.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorDto {

    private final int status;

    private final String message;

    private String stackTrace;

    private List<ValidationDetails> errors;

    @Data
    private static class ValidationDetails {
        private final String field;
        private final String message;
    }

}
