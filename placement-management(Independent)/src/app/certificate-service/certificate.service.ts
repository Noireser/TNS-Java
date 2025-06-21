import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {
  private baseUrl = '/api/certificates';

  constructor(private http: HttpClient) {}

  getAllCertificates(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  addCertificate(certificate: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, certificate);
  }

  updateCertificate(certificate: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, certificate);
  }

  deleteCertificate(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }
}
