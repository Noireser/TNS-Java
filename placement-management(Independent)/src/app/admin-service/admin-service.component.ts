import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService, Admin } from './admin.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-admin-service',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './admin-service.component.html',
  styleUrls: ['./admin-service.component.css']
})
export class AdminComponent implements OnInit {
  // For login form
  loginData = {
    name: '',
    password: ''
  };
  loginError: string | null = null;

  // The currently logged-in admin
  currentAdmin: Admin | null = null;

  // For updating current admin
  editAdminData: { id: number; name: string; password: string } = { id: 0, name: '', password: '' };

  // For adding new admin
  newAdmin = {
    name: '',
    password: ''
  };
  addAdminMessage: string | null = null;

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    // On init, check if an admin is stored in localStorage
    const stored = localStorage.getItem('loggedInAdmin');
    if (stored) {
      try {
        this.currentAdmin = JSON.parse(stored) as Admin;
        // initialize edit form with current data
        this.editAdminData = {
          id: this.currentAdmin.id,
          name: this.currentAdmin.name,
          password: this.currentAdmin.password
        };
      } catch {
        localStorage.removeItem('loggedInAdmin');
      }
    }
  }

  // Login handler
  login(): void {
    this.loginError = null;
    if (!this.loginData.name || !this.loginData.password) {
      this.loginError = 'Name and password are required.';
      return;
    }
    this.adminService.login(this.loginData).subscribe({
      next: (admin) => {
        this.currentAdmin = admin;
        // store in localStorage
        localStorage.setItem('loggedInAdmin', JSON.stringify(admin));
        // initialize edit form
        this.editAdminData = {
          id: admin.id,
          name: admin.name,
          password: admin.password
        };
        // clear login form
        this.loginData = { name: '', password: '' };
      },
      error: (err) => {
        console.error('Login error', err);
        this.loginError = 'Login failed. Check credentials.';
      }
    });
  }

  // Logout handler
  logout(): void {
    this.currentAdmin = null;
    localStorage.removeItem('loggedInAdmin');
    // Clear any edit/add messages
    this.addAdminMessage = null;
    this.loginError = null;
  }

  // Update current admin
  updateCurrentAdmin(): void {
    if (!this.currentAdmin) return;
    const updated: Admin = {
      id: this.editAdminData.id,
      name: this.editAdminData.name,
      password: this.editAdminData.password
    };
    this.adminService.updateAdmin(updated).subscribe({
      next: (admin) => {
        // Update localStorage and currentAdmin
        this.currentAdmin = admin;
        localStorage.setItem('loggedInAdmin', JSON.stringify(admin));
        alert('✅ Your admin profile has been updated.');
      },
      error: (err) => {
        console.error('Error updating admin', err);
        alert('❌ Failed to update profile.');
      }
    });
  }

  // Add a new admin
  addAdmin(): void {
    this.addAdminMessage = null;
    if (!this.newAdmin.name || !this.newAdmin.password) {
      this.addAdminMessage = 'Name and password are required.';
      return;
    }
    this.adminService.addAdmin(this.newAdmin).subscribe({
      next: (admin) => {
        this.addAdminMessage = `✅ Admin "${admin.name}" added with ID ${admin.id}.`;
        // clear form
        this.newAdmin = { name: '', password: '' };
      },
      error: (err) => {
        console.error('Error adding admin', err);
        this.addAdminMessage = '❌ Failed to add admin.';
      }
    });
  }
}
