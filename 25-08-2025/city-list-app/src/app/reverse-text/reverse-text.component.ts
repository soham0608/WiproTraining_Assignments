import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormControl } from '@angular/forms';

@Component({
  selector: 'reverse-text',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reverse-text.component.html',
  styleUrls: ['./reverse-text.component.css']
})
export class ReverseTextComponent {
  // Non-nullable control so value is always a string
  inputCtrl = new FormControl<string>('', { nonNullable: true });

  // Safely reverse Unicode text (handles emoji, etc.)
  get reversed(): string {
    const v = this.inputCtrl.value || '';
    return Array.from(v).reverse().join('');
  }
}
