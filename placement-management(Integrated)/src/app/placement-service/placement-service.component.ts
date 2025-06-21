import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PlacementService } from './placement.service';

@Component({
  selector: 'app-placement-service',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './placement-service.component.html',
  styleUrls: ['./placement-service.component.css']
})
export class PlacementServiceComponent implements OnInit {

  placement = {
    id: null,
    name: '',
    date: '',
    qualification: '',
    collegeId: null
  };

  placements: any[] = [];
  colleges: any[] = [];
  isEditMode = false;

  constructor(private placementService: PlacementService) {}

  ngOnInit(): void {
    this.loadColleges();
    this.loadPlacements();
  }

  loadColleges(): void {
    this.placementService.getAllColleges().subscribe({
      next: (data: any) => {
        this.colleges = data;
      },
      error: (err) => {
        console.error('Error loading colleges', err);
      }
    });
  }

  loadPlacements(): void {
    this.placementService.getAllPlacements().subscribe({
      next: (data: any) => {
        this.placements = data;
      },
      error: (err) => {
        console.error('Error loading placements', err);
      }
    });
  }

  extractYear(dateStr: string): number {
    const date = new Date(dateStr);
    return date.getFullYear();
  }

  addPlacement(): void {
    const payload = {
      name: this.placement.name,
      date: this.placement.date,
      qualification: this.placement.qualification,
      year: this.extractYear(this.placement.date),
      college: {
        id: this.placement.collegeId
      }
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

    const payload = {
      id: this.placement.id,
      name: this.placement.name,
      date: this.placement.date,
      qualification: this.placement.qualification,
      year: this.extractYear(this.placement.date),
      college: {
        id: this.placement.collegeId
      }
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

  editPlacement(p: any): void {
    this.placement = {
      id: p.id,
      name: p.name,
      date: p.date,
      qualification: p.qualification,
      collegeId: p.college?.id ?? null
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
      }
    });
  }

  resetForm(): void {
    this.placement = {
      id: null,
      name: '',
      date: '',
      qualification: '',
      collegeId: null
    };
    this.isEditMode = false;
  }

  getCollegeNameById(id: number): string {
    const college = this.colleges.find(c => c.id === id);
    return college ? college.collegeName : 'Unknown';
  }
}
