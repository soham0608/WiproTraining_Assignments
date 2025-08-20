import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celsiusToFahrenheit',
  standalone: true
})
export class CelsiusToFahrenheitPipe implements PipeTransform {
  transform(value: number | null | undefined): string {
    if (value === null || value === undefined || isNaN(value)) {
      return '';
    }
    const fahrenheit = (value * 9/5) + 32;
    return `${fahrenheit}F`;
  }
}
