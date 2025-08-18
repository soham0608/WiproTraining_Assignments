import { Component } from '@angular/core';

@Component({
  selector: 'app-inlinecomp',
  template: `
    <div class="container mt-5">
      <div class="alert alert-success text-center">
        <h3>Inline Component Works!</h3>
        <p>This component uses the <strong>template</strong> property with inline HTML.</p>
      </div>
    </div>
  `,
  styleUrls: ['./inlinecomp.component.css'],
  standalone: true,
  imports: [],
})
export class InlinecompComponent {}
