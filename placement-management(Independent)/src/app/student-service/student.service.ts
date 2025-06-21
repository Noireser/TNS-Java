import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Student {
  id?: number;
  name: string;
  roll: number;
  qualification: string;
  course: string;
  hallTicketNo: number;
  year: number;
}

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl = '/api/students';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}/all`);
  }

  addStudent(student: Student): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, student);
  }

  updateStudent(student: Student): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, student);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }
}
