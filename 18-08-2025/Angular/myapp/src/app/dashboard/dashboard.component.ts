import { Component } from '@angular/core';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-dashboard',
  template: `
    <app-home></app-home>
    <!-- You can add other components here as needed -->
  `,
  standalone: true,
  imports: [HomeComponent],
})
export class DashboardComponent {}
