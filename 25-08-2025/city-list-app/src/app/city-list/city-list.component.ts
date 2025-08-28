import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'city-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent {
  cities: string[] = ['Pune', 'Mumbai', 'Delhi', 'Bangalore', 'Chennai'];
}
