import { Component } from '@angular/core';
import { CityListComponent } from './city-list/city-list.component';
import { StepperFormComponent } from './stepper-form/stepper-form.component';
import { ReverseTextComponent } from './reverse-text/reverse-text.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component'; // 👈 add this

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CityListComponent,
    StepperFormComponent,
    ReverseTextComponent,
    RegistrationFormComponent // 👈 add this
  ],
  template: `
    <h1>Example App</h1>
    <city-list></city-list>
    <stepper-form></stepper-form>
    <reverse-text></reverse-text>
    <registration-form></registration-form> 
  `,
})
export class AppComponent {}
