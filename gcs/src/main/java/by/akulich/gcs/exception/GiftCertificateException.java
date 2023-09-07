package by.akulich.gcs.exception;

import org.springframework.http.HttpStatus;

public class GiftCertificateException extends BaseException{

    public GiftCertificateException(String message, HttpStatus httpStatus, String errorCode){
        super(message, httpStatus, errorCode);
    }

}
