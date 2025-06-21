// src/app/placement-service/placement.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Placement {
  id?: number;
  name: string;
  date: string;         // ISO date string, e.g. "2025-07-01"
  qualification: string;
  year: number;
}

@Injectable({
  providedIn: 'root'
})
export class PlacementService {
  private baseUrl = '/api/placements';

  constructor(private http: HttpClient) {}

  // Get all placements
  getAllPlacements(): Observable<Placement[]> {
    return this.http.get<Placement[]>(`${this.baseUrl}/all`);
  }

  // Add a new placement
  addPlacement(placement: Placement): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, placement);
  }

  // Update an existing placement
  updatePlacement(placement: Placement): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, placement);
  }

  // Delete placement by ID
  deletePlacement(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/cancel/${id}`);
  }
}
