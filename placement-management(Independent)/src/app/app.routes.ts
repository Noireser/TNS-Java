// src/app/routes.ts
import { Routes } from '@angular/router';
import { PlacementServiceComponent } from './placement-service/placement-service.component';
import { CertificateServiceComponent } from './certificate-service/certificate-service.component';
import { StudentServiceComponent } from './student-service/student-service.component';
// Import the standalone AdminComponent (not AdminServiceComponent)
import { AdminComponent } from './admin-service/admin-service.component';

export const routes: Routes = [
  { path: 'placement', component: PlacementServiceComponent },
  { path: 'certificate', component: CertificateServiceComponent },
  { path: 'student', component: StudentServiceComponent },
  { path: 'admin', component: AdminComponent },
  {
    path: 'users',
    loadComponent: () =>
      import('./user-service/user.component').then(m => m.UserComponent)
  },
  { path: '', redirectTo: 'placement', pathMatch: 'full' },
  // Optional fallback route for unknown paths:
  // { path: '**', redirectTo: 'placement' }
];
