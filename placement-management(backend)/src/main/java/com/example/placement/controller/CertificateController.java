package com.example.placement.controller;

import com.example.placement.model.Certificate;
import com.example.placement.service.CertificateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/add")
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateService.addCertificate(certificate);
    }

    @PutMapping("/update")
    public Certificate updateCertificate(@RequestBody Certificate certificate) {
        return certificateService.updateCertificate(certificate);
    }

    @GetMapping("/search/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return certificateService.searchCertificate(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCertificate(@PathVariable Long id) {
        return certificateService.deleteCertificate(id);
    }

    // ✅ New: Get all certificates
    @GetMapping("/all")
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }
}
