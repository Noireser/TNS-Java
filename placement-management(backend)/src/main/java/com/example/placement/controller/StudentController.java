package com.example.placement.controller;

import com.example.placement.model.Student;
import com.example.placement.model.Certificate;
import com.example.placement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // ✅ Constructor injection (Spring auto-wires this)
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST: Add student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // PUT: Update student
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    // GET: Search student by ID
    @GetMapping("/search/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.searchStudentById(id);
    }

    // GET: Search by hall ticket number
    @GetMapping("/hallticket/{ticketNo}")
    public Student getStudentByTicket(@PathVariable Long ticketNo) {
        return studentService.searchStudentByHallTicket(ticketNo);
    }

    // GET: View all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // DELETE: Delete student
    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    // POST: Add certificate
    @PostMapping("/certificate/add")
    public boolean addCertificate(@RequestBody Certificate certificate) {
        return studentService.addCertificate(certificate);
    }

    // PUT: Update certificate
    @PutMapping("/certificate/update")
    public boolean updateCertificate(@RequestBody Certificate certificate) {
        return studentService.updateCertificate(certificate);
    }
}
