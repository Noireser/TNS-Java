import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CertificateService } from './certificate.service';

@Component({
  selector: 'app-certificate-service',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './certificate-service.component.html',
  styleUrls: ['./certificate-service.component.css']
})
export class CertificateServiceComponent implements OnInit {
  certificates: any[] = [];

  // Only fields for Certificate itself; no collegeId
  certificate = {
    id: null as number | null,
    name: '',
    year: new Date().getFullYear()
  };

  isEdit = false;

  constructor(private certificateService: CertificateService) {}

  ngOnInit(): void {
    this.loadCertificates();
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

  submitCertificate(): void {
    // Build payload without college
    const payload: any = {
      name: this.certificate.name,
      year: this.certificate.year
    };
    // If editing, include id
    if (this.isEdit && this.certificate.id != null) {
      payload.id = this.certificate.id;
    }

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
      year: cert.year
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
      year: new Date().getFullYear()
    };
    this.isEdit = false;
  }
}
