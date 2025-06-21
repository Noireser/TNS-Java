import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlacementService {
  private baseUrl = '/api/placements';
  private collegeUrl = '/api/colleges';

  constructor(private http: HttpClient) {}

  getAllPlacements() {
    return this.http.get(`${this.baseUrl}/all`);
  }

  addPlacement(placement: any) {
    return this.http.post(`${this.baseUrl}/add`, placement);
  }

  updatePlacement(placement: any) {
    return this.http.put(`${this.baseUrl}/update`, placement);
  }

  deletePlacement(id: number) {
    return this.http.delete(`${this.baseUrl}/cancel/${id}`);
  }

  getAllColleges() {
    return this.http.get(`${this.collegeUrl}/all`);
  }
}
