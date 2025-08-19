import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-display-list',
  templateUrl: './display-list.component.html',
  styleUrls: ['./display-list.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class DisplayListComponent {
  fruits = [
    {
      name: 'Apple',
      image: 'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261_1280.jpg',
      description: 'A sweet, edible fruit produced by an apple tree.'
    },
    {
      name: 'Banana',
      image: 'assets/pngtree-banana-yellow-fruit.png',
      description: 'A long, curved fruit with a yellow skin and soft, sweet flesh.'
    },
    {
      name: 'Orange',
      image: 'Day2-AngularApp/src/assets/orange.jpg',
      description: 'A citrus fruit known for its juicy segments and vitamin C.'
    }
  ];
}
