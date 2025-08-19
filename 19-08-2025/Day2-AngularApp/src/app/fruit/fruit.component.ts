import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

export interface IFruit {
  name: string;
  color: string;
  taste: string;
}

@Component({
  selector: 'app-fruit',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fruit.component.html',
  styleUrls: ['./fruit.component.css']
})
export class FruitComponent {
  @Input() fruit!: IFruit;
  @Output() removeClick = new EventEmitter<string>();

  onRemove() {
    this.removeClick.emit(this.fruit.name);
  }
}
