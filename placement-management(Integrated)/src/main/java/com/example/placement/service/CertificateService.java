package com.example.placement.service;

import com.example.placement.model.Certificate;

public interface CertificateService {
    Certificate addCertificate(Certificate certificate);
    Certificate updateCertificate(Certificate certificate);
    Certificate searchCertificate(Long id);
    boolean deleteCertificate(Long id);
}
