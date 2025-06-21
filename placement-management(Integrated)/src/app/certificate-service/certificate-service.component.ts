import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CertificateService } from './certificate.service';

@Component({
  selector: 'app-certificate',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './certificate-service.component.html',
  styleUrls: ['./certificate-service.component.css']
})
export class CertificateComponent implements OnInit {
  certificates: any[] = [];
  colleges: any[] = [];

  certificate = {
    id: null,
    name: '',
    year: 2025,
    collegeId: null  // ✅ Changed from college: { id } to collegeId
  };

  isEdit = false;

  constructor(private certificateService: CertificateService) {}

  ngOnInit(): void {
    this.loadCertificates();
    this.loadColleges();
  }

  loadCertificates(): void {
    this.certificateService.getAllCertificates().subscribe({
      next: (data: any) => {
        this.certificates = data;
      },
      error: (err) => {
        console.error('Error loading certificates', err);
      }
    });
  }

  loadColleges(): void {
    this.certificateService.getAllColleges().subscribe({
      next: (data: any) => {
        this.colleges = data;
      },
      error: (err) => {
        console.error('Error loading colleges', err);
      }
    });
  }

  submitCertificate(): void {
    const payload = {
      id: this.certificate.id,
      name: this.certificate.name,
      year: this.certificate.year,
      college: {
        id: this.certificate.collegeId
      }
    };

    const action = this.isEdit
      ? this.certificateService.updateCertificate(payload)
      : this.certificateService.addCertificate(payload);

    action.subscribe({
      next: () => {
        alert(`✅ Certificate ${this.isEdit ? 'updated' : 'added'} successfully!`);
        this.resetForm();
        this.loadCertificates();
      },
      error: (err) => {
        console.error('Error submitting certificate', err);
        alert('❌ Failed to submit certificate');
      }
    });
  }

  editCertificate(cert: any): void {
    this.certificate = {
      id: cert.id,
      name: cert.name,
      year: cert.year,
      collegeId: cert.college?.id ?? null
    };
    this.isEdit = true;
  }

  deleteCertificate(id: number): void {
    if (confirm('Are you sure you want to delete this certificate?')) {
      this.certificateService.deleteCertificate(id).subscribe({
        next: () => {
          alert('🗑️ Certificate deleted successfully');
          this.loadCertificates();
        },
        error: (err) => {
          console.error('Error deleting certificate', err);
          alert('❌ Failed to delete certificate');
        }
      });
    }
  }

  resetForm(): void {
    this.certificate = {
      id: null,
      name: '',
      year: 2025,
      collegeId: null
    };
    this.isEdit = false;
  }

  getCollegeNameById(id: number): string {
    const college = this.colleges.find(c => c.id === id);
    return college ? college.collegeName : 'Unknown';
  }
}
