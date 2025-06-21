package com.example.placement.service;

import com.example.placement.model.Student;
import com.example.placement.model.Certificate;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student updateStudent(Student student);
    Student searchStudentById(Long id);
    Student searchStudentByHallTicket(Long hallTicketNo);
    boolean deleteStudent(Long id);
    boolean addCertificate(Certificate certificate);
    boolean updateCertificate(Certificate certificate);
    List<Student> getAllStudents(); // ✅ Added
}
