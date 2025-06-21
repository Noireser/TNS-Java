package com.example.placement.service.impl;

import com.example.placement.model.Student;
import com.example.placement.model.Certificate;
import com.example.placement.repository.StudentRepository;
import com.example.placement.repository.CertificateRepository;
import com.example.placement.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List; // ✅ This fixes the “List cannot be resolved” error

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CertificateRepository certificateRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CertificateRepository certificateRepository) {
        this.studentRepository = studentRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student searchStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student searchStudentByHallTicket(Long hallTicketNo) {
        return studentRepository.findByHallTicketNo(hallTicketNo);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean addCertificate(Certificate certificate) {
        certificateRepository.save(certificate);
        return true;
    }

    @Override
    public boolean updateCertificate(Certificate certificate) {
        certificateRepository.save(certificate);
        return true;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
