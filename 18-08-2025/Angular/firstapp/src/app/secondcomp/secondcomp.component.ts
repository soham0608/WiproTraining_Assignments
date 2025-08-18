import { Component } from '@angular/core';

@Component({
  selector: 'app-secondcomp',
  templateUrl: './secondcomp.component.html',
  styleUrls: ['./secondcomp.component.css'], // Correct property name and array
  standalone: true, // Add this line
  imports: [],
})
export class SecondcompComponent {

}
