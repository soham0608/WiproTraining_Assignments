import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReverseTextComponent } from './reverse-text.component';

describe('ReverseTextComponent', () => {
  let component: ReverseTextComponent;
  let fixture: ComponentFixture<ReverseTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReverseTextComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReverseTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
