package by.akulich.gcs.exception;

import org.springframework.http.HttpStatus;

public class GiftCertificateException extends RuntimeException{

    private final HttpStatus status;

    public GiftCertificateException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
