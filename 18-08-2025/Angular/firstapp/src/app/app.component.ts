import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SecondcompComponent } from './secondcomp/secondcomp.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [SecondcompComponent],
  standalone: true,
})
export class AppComponent {
  title = 'firstapp';
}
