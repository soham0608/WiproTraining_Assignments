import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';

// Angular Material imports
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'registration-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule
  ],
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent {
  regForm: FormGroup;
  subjects = ['Computer Science', 'Mathematics', 'Physics', 'Chemistry', 'Biology'];

  constructor(private fb: FormBuilder) {
    this.regForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      dob: ['', Validators.required],
      subject: ['', Validators.required]
    });
  }

  submit(): void {
    if (this.regForm.valid) {
      console.log('Form Submitted:', this.regForm.value);
      alert('Registration Successful!\n\n' + JSON.stringify(this.regForm.value, null, 2));
      this.regForm.reset();
    }
  }
}
