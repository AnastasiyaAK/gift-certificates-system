package by.akulich.gcs.controllers;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.entities.GiftCertificate;
import by.akulich.gcs.services.GiftCertificateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gift-certificates")
public class BookController {
    private final GiftCertificateService giftCertificateService = new GiftCertificateService();

    @PostMapping("/create")
    public GiftCertificate createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        return giftCertificateService.addGiftCertificate(giftCertificateDto);
    }
}
