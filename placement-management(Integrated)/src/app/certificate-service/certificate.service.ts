import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {
  private baseUrl = '/api/certificates';
  private collegeUrl = '/api/colleges';

  constructor(private http: HttpClient) {}

  getAllCertificates() {
    return this.http.get(`${this.baseUrl}/all`);
  }

  addCertificate(certificate: any) {
    return this.http.post(`${this.baseUrl}/add`, certificate);
  }

  updateCertificate(certificate: any) {
    return this.http.put(`${this.baseUrl}/update`, certificate);
  }

  deleteCertificate(id: number) {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

  getAllColleges() {
    return this.http.get(`${this.collegeUrl}/all`);
  }
}
