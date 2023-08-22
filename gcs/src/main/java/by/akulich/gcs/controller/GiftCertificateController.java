package by.akulich.gcs.controller;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.service.GiftCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gift-certificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @PostMapping
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        return giftCertificateService.addGiftCertificate(giftCertificateDto);
    }
}
