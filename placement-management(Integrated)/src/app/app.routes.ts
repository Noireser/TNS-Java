// src/app/routes.ts
import { Routes } from '@angular/router';
import { PlacementServiceComponent } from './placement-service/placement-service.component';
import { CertificateComponent } from './certificate-service/certificate-service.component';
import { StudentServiceComponent } from './student-service/student-service.component';
import { AdminServiceComponent } from './admin-service/admin-service.component';

export const routes: Routes = [
  { path: 'placement', component: PlacementServiceComponent },
  { path: 'certificate', component: CertificateComponent },
  { path: 'student', component: StudentServiceComponent },
  { path: 'admin', component: AdminServiceComponent },
  {
    path: 'users',
    loadComponent: () => import('./user-service/user.component').then(m => m.UserComponent)
  },
  { path: '', redirectTo: 'placement', pathMatch: 'full' }
];
