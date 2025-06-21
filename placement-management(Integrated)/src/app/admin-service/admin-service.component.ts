import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin-service',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-service.component.html',
  styleUrls: ['./admin-service.component.css'],
})
export class AdminServiceComponent implements OnInit {
  users: any[] = [];
  colleges: any[] = [];
  newAdmin = { name: '', password: '' };

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadAllUsers();
    this.loadAllColleges();
  }

  // ✅ Get all users (not just pending)
  loadAllUsers(): void {
    this.http.get<any[]>('http://localhost:8080/api/users/all').subscribe({
      next: (data) => this.users = data,
      error: (err) => console.error('Error fetching users', err)
    });
  }

  // ✅ Get all colleges
  loadAllColleges(): void {
    this.http.get<any[]>('http://localhost:8080/api/colleges/all').subscribe({
      next: (data) => this.colleges = data,
      error: (err) => console.error('Error fetching colleges', err)
    });
  }

  // ✅ Approve user
  approveUser(id: number): void {
    this.http.put(`http://localhost:8080/api/users/approve/${id}`, {}).subscribe(() => {
      this.loadAllUsers();
    });
  }

  // ✅ Reject user
  rejectUser(user: any): void {
    user.approved = false;
    this.http.put(`http://localhost:8080/api/users/update/`, this.users).subscribe(() => {
      this.loadAllUsers();
    });
  }

  // ✅ Delete user
  deleteUser(id: number): void {
    this.http.delete(`http://localhost:8080/api/users/delete/${id}`).subscribe(() => {
      this.loadAllUsers();
    });
  }

  // ✅ Approve college
  approveCollege(college: any): void {
    college.approved = true;
    this.http.put(`http://localhost:8080/api/colleges/update`, college).subscribe(() => {
      this.loadAllColleges();
    });
  }

  // ✅ Reject college
  rejectCollege(college: any): void {
    college.approved = false;
    this.http.put(`http://localhost:8080/api/colleges/update`, college).subscribe(() => {
      this.loadAllColleges();
    });
  }

  // ✅ Delete college
  deleteCollege(id: number): void {
    this.http.delete(`http://localhost:8080/api/colleges/delete/${id}`).subscribe(() => {
      this.loadAllColleges();
    });
  }

  // ✅ Add admin
  addAdmin(): void {
    this.http.post(`http://localhost:8080/api/admins/add`, this.newAdmin).subscribe(() => {
      alert('Admin added successfully');
      this.newAdmin = { name: '', password: '' };
    });
  }
}
