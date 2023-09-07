package by.akulich.gcs.exception;

import org.springframework.http.HttpStatus;

public class TagException extends BaseException{

    protected TagException(String message, HttpStatus httpStatus, String errorCode) {
        super(message, httpStatus, errorCode);
    }

}
