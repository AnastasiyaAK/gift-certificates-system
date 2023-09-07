package by.akulich.gcs.controller;

import by.akulich.gcs.dto.GiftCertificateDto;
import by.akulich.gcs.service.GiftCertificateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gift-certificates")
public class GiftCertificateController {

    private final GiftCertificateService giftCertificateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        log.debug("Requested create Girt Certificate with name " + giftCertificateDto.getName());
        return giftCertificateService.addGiftCertificate(giftCertificateDto);
    }
}
