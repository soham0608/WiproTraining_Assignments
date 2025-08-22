import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleCompComponent } from './vehicle-comp.component';

describe('VehicleCompComponent', () => {
  let component: VehicleCompComponent;
  let fixture: ComponentFixture<VehicleCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehicleCompComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehicleCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
