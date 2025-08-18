import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-colordropdown',
  template: `
    <select class="form-select mb-3" [(ngModel)]="selectedColor">
      <option *ngFor="let color of colors" [value]="color">{{ color }}</option>
    </select>
    <h3 [style.color]="selectedColor">This text changes color!</h3>
  `,
  standalone: true,
  imports: [FormsModule, CommonModule],
})
export class ColordropdownComponent {
  colors: string[] = ['red', 'green', 'blue', 'orange', 'purple'];
  selectedColor: string = '';
}
