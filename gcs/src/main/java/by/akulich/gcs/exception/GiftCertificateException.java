package by.akulich.gcs.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseException extends RuntimeException{

    private final HttpStatus httpStatus;

    private final String errorCode;

    public BaseException(String message, HttpStatus httpStatus, String errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

}
