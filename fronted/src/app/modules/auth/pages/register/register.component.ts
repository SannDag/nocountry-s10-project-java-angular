import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Registro } from 'src/app/models/registro';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
   registroForm!: FormGroup;

   constructor(private formBuilder: FormBuilder, private authService:AuthService) {}

  ngOnInit() {
    this.registroForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8),]],
 
    });
  }
  get email(){
    return this.registroForm.controls['email'];
  }

  get password()
  {
    return this.registroForm.controls['password'];
  }
  get name()
  {
    return this.registroForm.controls['nombre'];
  }
  get lastName()
  {
    return this.registroForm.controls['apellido'];
  }



  registrarUsuario(){
    const nuevoUsuario: Registro = this.registroForm.value;
    this.authService.registro(nuevoUsuario)
    .subscribe( response =>{
        console.log('Usuario registrado:', response);
    })
    
  }


}
