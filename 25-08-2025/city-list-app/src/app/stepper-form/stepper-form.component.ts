import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'stepper-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './stepper-form.component.html',
  styleUrls: ['./stepper-form.component.css']
})
export class StepperFormComponent {
  step: number = 1;

  formData = {
    name: '',
    age: null,
    email: ''
  };

  nextStep() {
    if (this.step < 3) {
      this.step++;
    }
  }

  prevStep() {
    if (this.step > 1) {
      this.step--;
    }
  }

  submitForm() {
    alert(`Submitted!\nName: ${this.formData.name}\nAge: ${this.formData.age}\nEmail: ${this.formData.email}`);
  }
}
