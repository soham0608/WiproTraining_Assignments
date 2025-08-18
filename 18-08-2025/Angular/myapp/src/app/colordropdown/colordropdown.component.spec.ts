import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColordropdownComponent } from './colordropdown.component';

describe('ColordropdownComponent', () => {
  let component: ColordropdownComponent;
  let fixture: ComponentFixture<ColordropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ColordropdownComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ColordropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
