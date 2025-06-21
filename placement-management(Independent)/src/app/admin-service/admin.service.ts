import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Admin {
  id: number;
  name: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl = '/api/admins';

  constructor(private http: HttpClient) {}

  // Login: expects { name, password }
  login(credentials: { name: string; password: string }): Observable<Admin> {
    return this.http.post<Admin>(`${this.baseUrl}/login`, credentials);
  }

  // Add new admin
  addAdmin(admin: { name: string; password: string }): Observable<Admin> {
    return this.http.post<Admin>(`${this.baseUrl}/add`, admin);
  }

  // Update admin (id must be present)
  updateAdmin(admin: Admin): Observable<Admin> {
    return this.http.put<Admin>(`${this.baseUrl}/update`, admin);
  }
}
