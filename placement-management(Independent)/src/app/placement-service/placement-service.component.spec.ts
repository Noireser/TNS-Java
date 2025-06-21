import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacementServiceComponent } from './placement-service.component';

describe('PlacementServiceComponent', () => {
  let component: PlacementServiceComponent;
  let fixture: ComponentFixture<PlacementServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlacementServiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlacementServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
