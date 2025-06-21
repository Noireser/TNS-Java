// src/app/placement-service/placement-service.component.ts
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PlacementService, Placement } from './placement.service';

@Component({
  selector: 'app-placement-service',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './placement-service.component.html',
  styleUrls: ['./placement-service.component.css']
})
export class PlacementServiceComponent implements OnInit {

  // The form model: only placement fields
  placement: {
    id: number | null;
    name: string;
    date: string;
    qualification: string;
  } = {
    id: null,
    name: '',
    date: '',
    qualification: ''
  };

  placements: Placement[] = [];
  isEditMode = false;

  constructor(private placementService: PlacementService) {}

  ngOnInit(): void {
    this.loadPlacements();
  }

  loadPlacements(): void {
    this.placementService.getAllPlacements().subscribe({
      next: (data: Placement[]) => {
        this.placements = data;
      },
      error: (err) => {
        console.error('Error loading placements', err);
      }
    });
  }

  // Extract year (full numeric) from the date string (YYYY-MM-DD)
  private extractYear(dateStr: string): number {
    if (!dateStr) {
      // fallback to current year
      return new Date().getFullYear();
    }
    const parts = dateStr.split('-');
    const y = parseInt(parts[0], 10);
    return isNaN(y) ? new Date().getFullYear() : y;
  }

  addPlacement(): void {
    // Build payload without id
    const payload: Placement = {
      name: this.placement.name,
      date: this.placement.date,
      qualification: this.placement.qualification,
      year: this.extractYear(this.placement.date)
    };

    this.placementService.addPlacement(payload).subscribe({
      next: () => {
        alert('✅ Placement added successfully!');
        this.resetForm();
        this.loadPlacements();
      },
      error: (err) => {
        console.error('Error adding placement', err);
        alert('❌ Failed to add placement');
      }
    });
  }

  updatePlacement(): void {
    if (this.placement.id === null) return;

    const payload: Placement = {
      id: this.placement.id,
      name: this.placement.name,
      date: this.placement.date,
      qualification: this.placement.qualification,
      year: this.extractYear(this.placement.date)
    };

    this.placementService.updatePlacement(payload).subscribe({
      next: () => {
        alert('✅ Placement updated!');
        this.resetForm();
        this.isEditMode = false;
        this.loadPlacements();
      },
      error: (err) => {
        console.error('Error updating placement', err);
        alert('❌ Failed to update placement');
      }
    });
  }

  editPlacement(p: Placement): void {
    this.placement = {
      id: p.id ?? null,
      name: p.name,
      date: p.date,
      qualification: p.qualification
    };
    this.isEditMode = true;
  }

  deletePlacement(id: number): void {
    if (!confirm('Are you sure you want to delete this placement?')) return;

    this.placementService.deletePlacement(id).subscribe({
      next: () => {
        alert('🗑️ Placement deleted');
        this.loadPlacements();
      },
      error: (err) => {
        console.error('Error deleting placement', err);
        alert('❌ Failed to delete placement');
      }
    });
  }

  resetForm(): void {
    this.placement = {
      id: null,
      name: '',
      date: '',
      qualification: ''
    };
    this.isEditMode = false;
  }
}
