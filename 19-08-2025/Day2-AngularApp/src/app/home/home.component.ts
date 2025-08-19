import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FruitComponent, IFruit } from '../fruit/fruit.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FruitComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  fruits: IFruit[] = [
    { name: 'Apple', color: 'Red', taste: 'Sweet' },
    { name: 'Banana', color: 'Yellow', taste: 'Sweet' },
    { name: 'Orange', color: 'Orange', taste: 'Citrusy' }
  ];

  removeFruit(fruitName: string) {
    this.fruits = this.fruits.filter(f => f.name !== fruitName);
    console.log('Removed fruit:', fruitName);
  }
}
