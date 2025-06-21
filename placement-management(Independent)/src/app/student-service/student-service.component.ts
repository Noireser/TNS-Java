import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { StudentService, Student } from './student.service';

@Component({
  selector: 'app-student-service',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './student-service.component.html',
  styleUrls: ['./student-service.component.css']
})
export class StudentServiceComponent implements OnInit {
  students: Student[] = [];

  // Form model: only own fields
  student: {
    id: number | null;
    name: string;
    roll: number | null;
    qualification: string;
    course: string;
    hallTicketNo: number | null;
    year: number | null;
  } = {
    id: null,
    name: '',
    roll: null,
    qualification: '',
    course: '',
    hallTicketNo: null,
    year: null
  };

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getAllStudents().subscribe({
      next: (data: Student[]) => {
        this.students = data;
      },
      error: (err) => {
        console.error('Error loading students', err);
      }
    });
  }

  saveStudent(): void {
    // Build payload from form model
    const payload: Student = {
      name: this.student.name,
      roll: this.student.roll ?? 0,
      qualification: this.student.qualification,
      course: this.student.course,
      hallTicketNo: this.student.hallTicketNo ?? 0,
      year: this.student.year ?? new Date().getFullYear()
    };
    if (this.student.id != null) {
      // Update: include id
      payload.id = this.student.id;
      this.studentService.updateStudent(payload).subscribe({
        next: () => {
          alert('✅ Student updated successfully!');
          this.loadStudents();
          this.resetForm();
        },
        error: (err) => {
          console.error('Error updating student', err);
          alert('❌ Failed to update student');
        }
      });
    } else {
      // Add new
      this.studentService.addStudent(payload).subscribe({
        next: () => {
          alert('✅ Student added successfully!');
          this.loadStudents();
          this.resetForm();
        },
        error: (err) => {
          console.error('Error adding student', err);
          alert('❌ Failed to add student');
        }
      });
    }
  }

  editStudent(s: Student): void {
    this.student = {
      id: s.id ?? null,
      name: s.name,
      roll: s.roll,
      qualification: s.qualification,
      course: s.course,
      hallTicketNo: s.hallTicketNo,
      year: s.year
    };
  }

  deleteStudent(id: number): void {
    if (!confirm('Are you sure you want to delete this student?')) {
      return;
    }
    this.studentService.deleteStudent(id).subscribe({
      next: () => {
        alert('🗑️ Student deleted successfully');
        this.loadStudents();
      },
      error: (err) => {
        console.error('Error deleting student', err);
        alert('❌ Failed to delete student');
      }
    });
  }

  resetForm(): void {
    this.student = {
      id: null,
      name: '',
      roll: null,
      qualification: '',
      course: '',
      hallTicketNo: null,
      year: null
    };
  }
}
