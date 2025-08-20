import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlightStrikethru]',
  standalone: true
})
export class HighlightStrikethruDirective {

  constructor(private elementRef: ElementRef) {
    this.elementRef.nativeElement.style.color = 'yellow';
    this.elementRef.nativeElement.style.textDecoration = 'line-through';
    this.elementRef.nativeElement.style.fontWeight = 'bold';
  }
}
