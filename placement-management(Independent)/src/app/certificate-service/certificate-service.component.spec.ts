import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertificateServiceComponent } from './certificate-service.component';

describe('CertificateServiceComponent', () => {
  let component: CertificateServiceComponent;
  let fixture: ComponentFixture<CertificateServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CertificateServiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CertificateServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
