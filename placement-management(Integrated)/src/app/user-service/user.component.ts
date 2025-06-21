import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: any[] = [];
  editingUser: any = null;

  newUser: any = {
    name: '',
    password: '',
    type: 'college'
  };

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.http.get<any[]>('http://localhost:8080/api/users/all').subscribe({
      next: (data) => this.users = data,
      error: (err) => console.error('Error loading users', err)
    });
  }

  addUser(): void {
    this.http.post('http://localhost:8080/api/users/add', this.newUser).subscribe({
      next: () => {
        this.newUser = { name: '', password: '', type: 'college' };
        this.loadUsers();
      },
      error: (err) => console.error('Error adding user', err)
    });
  }

  startEdit(user: any): void {
    this.editingUser = { ...user };
  }

  cancelEdit(): void {
    this.editingUser = null;
  }

  updateUser(): void {
    this.http.put('http://localhost:8080/api/users/update', this.editingUser).subscribe({
      next: () => {
        this.editingUser = null;
        this.loadUsers();
      },
      error: (err) => console.error('Error updating user', err)
    });
  }

  deleteUser(id: number): void {
    this.http.delete(`http://localhost:8080/api/users/delete/${id}`).subscribe({
      next: () => this.loadUsers(),
      error: (err) => console.error('Error deleting user', err)
    });
  }
}
