import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';



@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.scss'],


})
export class CalculadoraComponent {

  selectedvalue = 100000;
  formulario!: FormGroup;
  valueButton = 0;
  resultado = 0;

  constructor(private fb: FormBuilder) {
    // Configura el formulario reactivo
    this.formulario = this.fb.group({
      necesito: [this.selectedvalue],
      
    });
  }

  calcularDatos(valueButton: any,selectedvalue:any){
    const tasa = 0.01;

    this.resultado=(selectedvalue * tasa)/ (1 - Math.pow(1 + tasa, -valueButton));

    this.resultado = parseFloat(this.resultado.toFixed(0));


  }

  // Función para manejar el cambio de valor del slider
  onSliderChange(event: any) {
    this.selectedvalue = event.value;
    // Actualiza el valor en el formulario reactivo
    this.formulario.get('necesito')?.setValue(this.selectedvalue);
  }
  

  onSubmit(valueButton: any,selectedvalue:any) {
   

    
    switch (valueButton) {
      case 3:

      this.calcularDatos(valueButton,selectedvalue)
    //     console.log("Lunes");
    //     console.log(selectedvalue)
    // this.resultado=(selectedvalue * tasa)/ (1 - Math.pow(1 + tasa, -valueButton));
    // console.log(this.resultado)

    break;
  case 6:
    console.log("Martes");
    this.calcularDatos(valueButton,selectedvalue)

    break;
  case 12:
    console.log("Miércoles");
    this.calcularDatos(valueButton,selectedvalue)

    break;
  
  default:
    console.log("No es un día válido");
    
}


  }



}
