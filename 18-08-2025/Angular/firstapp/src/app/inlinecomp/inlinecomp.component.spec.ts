import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InlinecompComponent } from './inlinecomp.component';

describe('InlinecompComponent', () => {
  let component: InlinecompComponent;
  let fixture: ComponentFixture<InlinecompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InlinecompComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InlinecompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
