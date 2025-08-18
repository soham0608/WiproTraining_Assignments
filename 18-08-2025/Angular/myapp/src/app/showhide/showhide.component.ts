import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Import FormsModule

@Component({
  selector: 'app-showhide',
  template: `
    <div class="form-check mb-3">
      <input type="checkbox" class="form-check-input" id="toggleMsg" [(ngModel)]="showMessage">
      <label class="form-check-label" for="toggleMsg">Show Message</label>
    </div>
    <div *ngIf="showMessage" class="alert alert-info">
      This is a toggled message!
    </div>
  `,
  standalone: true,
  imports: [CommonModule, FormsModule], // Add FormsModule here
})
export class ShowhideComponent {
  showMessage = false;
}