// src/app/admin-service.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AdminServiceService {
  private baseUrl = '/api'; // Update if needed

  constructor(private http: HttpClient) {}

  // College approvals
  getUnapprovedColleges(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/colleges/unapproved`);
  }

  approveCollege(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/colleges/${id}/approve`, {});
  }

  rejectCollege(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/colleges/${id}/reject`, {});
  }

  deleteCollege(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/colleges/${id}`);
  }

  // Corporate users approvals
  getUnapprovedUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/users/unapproved`);
  }

  approveUser(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/users/${id}/approve`, {});
  }

  rejectUser(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/users/${id}/reject`, {});
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/users/${id}`);
  }

  // Add new admin
  addAdmin(admin: { name: string; password: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/admin/add`, admin);
  }
}
