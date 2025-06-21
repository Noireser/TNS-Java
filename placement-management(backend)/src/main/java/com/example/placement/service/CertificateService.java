package com.example.placement.service;

import com.example.placement.model.Certificate;

import java.util.List;

public interface CertificateService {
    Certificate addCertificate(Certificate certificate);
    Certificate updateCertificate(Certificate certificate);
    Certificate searchCertificate(Long id);
    boolean deleteCertificate(Long id);

    // ✅ New method
    List<Certificate> getAllCertificates();
}
