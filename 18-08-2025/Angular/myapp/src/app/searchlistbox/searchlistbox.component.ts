import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-searchlistbox',
  template: `
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="Search names..." [(ngModel)]="searchText">
    </div>
    <select class="form-select" size="6">
      <option *ngFor="let name of filteredNames()" [value]="name">{{ name }}</option>
    </select>
  `,
  standalone: true,
  imports: [FormsModule, CommonModule],
})
export class SearchlistboxComponent {
  names: string[] = ['Jayanta', 'Soham', 'Pratham', 'Aniket', 'Kshitij', 'Ajay', 'Raj'];
  searchText: string = '';

  filteredNames(): string[] {
    const query = this.searchText.toLowerCase();
    return this.names.filter(name => name.toLowerCase().startsWith(query));
  }
}