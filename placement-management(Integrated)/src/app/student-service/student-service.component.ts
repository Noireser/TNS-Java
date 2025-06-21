// src/app/student/student.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { StudentService } from './student.service';

@Component({
  selector: 'app-student-service',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './student-service.component.html',
  styleUrls: ['./student-service.component.css']
})
export class StudentServiceComponent implements OnInit {
  students: any[] = [];
  colleges: any[] = [];
  certificates: any[] = [];

  student = {
    id: null,
    name: '',
    roll: '',
    qualification: '',
    course: '',
    hallTicketNo: null,
    year: null,
    college: null,
    certificate: null
  };

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
    this.loadColleges();
    this.loadCertificates();
  }

  loadStudents() {
    this.studentService.getAllStudents().subscribe(data => {
      this.students = data;
    });
  }

  loadColleges() {
    this.studentService.getAllColleges().subscribe(data => {
      this.colleges = data;
    });
  }

  loadCertificates() {
    this.studentService.getAllCertificates().subscribe(data => {
      this.certificates = data;
    });
  }

  saveStudent() {
    if (this.student.id) {
      this.studentService.updateStudent(this.student).subscribe(() => {
        this.loadStudents();
        this.resetForm();
      });
    } else {
      this.studentService.addStudent(this.student).subscribe(() => {
        this.loadStudents();
        this.resetForm();
      });
    }
  }

  editStudent(s: any) {
    this.student = { ...s };
  }

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id).subscribe(() => {
      this.loadStudents();
    });
  }

  resetForm() {
    this.student = {
      id: null,
      name: '',
      roll: '',
      qualification: '',
      course: '',
      hallTicketNo: null,
      year: null,
      college: null,
      certificate: null
    };
  }

  getCollegeNameById(id: number): string {
    const college = this.colleges.find(c => c.id === id);
    return college ? college.collegeName : 'Unknown';
  }
}
