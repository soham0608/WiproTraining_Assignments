import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

interface Book {
  title: string;
  description: string;
  image: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [CommonModule],
})
export class HomeComponent {
  books: Book[] = Array.from({ length: 20 }, (_, i) => ({
    title: `Book Title ${i + 1}`,
    description: `This is a short description for Book ${i + 1}.`,
    image: `https://static.vecteezy.com/system/resources/previews/009/399/398/original/old-vintage-book-clipart-design-illustration-free-png${i + 1}.webp`, 
  }));
}
