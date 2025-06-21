package com.example.placement.service.impl;

import com.example.placement.model.Certificate;
import com.example.placement.repository.CertificateRepository;
import com.example.placement.service.CertificateService;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate addCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate searchCertificate(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
        return true;
    }
}
