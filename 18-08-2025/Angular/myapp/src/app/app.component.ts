import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Import CommonModule

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [FormsModule, CommonModule], // Add CommonModule here
})
export class AppComponent {
  message: string = 'Welcome to Angular!';
  names: string[] = ['Alice', 'Bob', 'Charlie', 'David'];

  printMessage() {
    console.log(this.message);
  }
}
