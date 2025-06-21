// src/app/student/student.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl = '/api/students';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all`);
  }

  addStudent(student: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, student);
  }

  updateStudent(student: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, student);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

  getAllColleges(): Observable<any[]> {
    return this.http.get<any[]>('/api/colleges/all');
  }

  getAllCertificates(): Observable<any[]> {
    return this.http.get<any[]>('/api/certificates/all');
  }
}
