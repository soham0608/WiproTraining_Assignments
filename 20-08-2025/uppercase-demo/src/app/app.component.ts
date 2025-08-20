import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DatePipe, CommonModule } from '@angular/common';  
import { UppercasePipe } from './uppercase.pipe';
import { CelsiusToFahrenheitPipe } from './celsius-to-fahrenheit.pipe';
import { HighlightStrikethruDirective } from './highlight-strikethru.directive';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,               
    FormsModule,
    DatePipe,
    UppercasePipe,
    CelsiusToFahrenheitPipe,
    HighlightStrikethruDirective
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  inputText: string = '';    
  selectedDate: string = ''; 
  celsius: number | undefined;   
  get dateObj(): Date | null {
    return this.selectedDate ? new Date(this.selectedDate) : null;
  }
}
