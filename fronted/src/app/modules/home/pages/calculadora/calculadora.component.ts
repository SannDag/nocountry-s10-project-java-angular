import { Component } from '@angular/core';


@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.scss'],


})
export class CalculadoraComponent {

  selectedvalue = 0;

  // formatLabel(value: number): string {
  //   if (value >= 1000) {
  //     return Math.round(value / 1000) + 'k';
  //   }

  //   return `${value}`;
  // }

}
