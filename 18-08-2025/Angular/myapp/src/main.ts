// import { bootstrapApplication } from '@angular/platform-browser';
// import { Component } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { CommonModule } from '@angular/common'; // Import CommonModule

// @Component({
//   selector: 'app-countrydropdown',
//   template: `
//     <button class="btn btn-primary mb-3" (click)="loadCountries()">Load</button>
//     <select class="form-select">
//       <option *ngFor="let country of loadedCountries" [value]="country">{{ country }}</option>
//     </select>
//   `,
//   standalone: true,
//   imports: [FormsModule, CommonModule], // Add CommonModule here
// })
// export class CountrydropdownComponent {
//   countryNames: string[] = ['India', 'USA', 'Canada', 'Australia', 'Germany'];
//   loadedCountries: string[] = [];

//   loadCountries() {
//     this.loadedCountries = [...this.countryNames];
//   }
// }

// bootstrapApplication(CountrydropdownComponent)
//   .catch(err => console.error(err));

// import { bootstrapApplication } from '@angular/platform-browser';
// import { Component } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { CommonModule } from '@angular/common';

// @Component({
//   selector: 'app-colordropdown',
//   template: `
//     <select class="form-select mb-3" [(ngModel)]="selectedColor">
//       <option *ngFor="let color of colors" [value]="color">{{ color }}</option>
//     </select>
//     <h3 [style.color]="selectedColor">This text changes color!</h3>
//   `,
//   standalone: true,
//   imports: [FormsModule, CommonModule],
/// })
// export class ColordropdownComponent {
//   colors: string[] = ['red', 'green', 'blue', 'orange', 'purple'];
//   selectedColor: string = '';
// }

// bootstrapApplication(ColordropdownComponent)
//   .catch(err => console.error(err));

import { bootstrapApplication } from '@angular/platform-browser';
import { DashboardComponent } from './app/dashboard/dashboard.component';

bootstrapApplication(DashboardComponent)
  .catch(err => console.error(err));