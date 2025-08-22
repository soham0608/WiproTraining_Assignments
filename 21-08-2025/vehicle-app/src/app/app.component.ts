import { Component } from '@angular/core';
import { VehicleCompComponent } from './vehicle-comp/vehicle-comp.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [VehicleCompComponent],
  template: `
    <h1>Welcome to Vehicle App</h1>
    <app-vehicle-comp></app-vehicle-comp>
  `
})
export class AppComponent {}
