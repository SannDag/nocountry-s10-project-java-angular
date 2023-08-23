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

   registerSuccess:string = "";

      registroForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]]


    })


   constructor(private formBuilder: FormBuilder, private authService:AuthService) {}

  ngOnInit() {}

  get email(){
    return this.registroForm.controls.email;
  }

  get password()
  {
    return this.registroForm.controls.password;
  }
  get name()
  {
    return this.registroForm.controls.name;
  }
  get lastname()
  {
    return this.registroForm.controls.lastname;
  }



  registrarUsuario(){

    if(this.registroForm.valid){
      this.authService.registro(this.registroForm.value as Registro).subscribe({
        next: response =>{
          console.log(response);
        },
        error: err =>{
          console.log(err);
        },
        complete: () => {
          console.log("Registro completo");
        }


      })
    }else{

      this.registroForm.markAllAsTouched();
      alert("Error al ingresar los datos.");
    }

  }




}
