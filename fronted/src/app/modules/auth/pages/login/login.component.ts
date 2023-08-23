import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/models/login-request';
import { AuthService } from 'src/app/services/auth.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  loginError:string="";
  loginSuccess: string = "";

  loginForm = this.fb.group({
    email:['', [Validators.required,Validators.email]],
    password:['',Validators.required]
  })

  constructor(private fb: FormBuilder, private router:Router, private authService:AuthService,
    private tokenService:TokenService){}

  ngOnInit(): void {

  }
  get email(){
    return this.loginForm.controls.email;
  }

  get password()
  {
    return this.loginForm.controls.password;
  }

  login(){
    if(this.loginForm.valid){
      this.loginError = '';
      this.authService.login(this.loginForm.value as LoginRequest).subscribe({
        next: (response) => {
          console.log(response);
          //seteo en el localEstore el token, rol y email del usuario logueado
          this.tokenService.setToken(response.token);
          this.tokenService.setRol(response.rol);
          this.tokenService.setEmail(response.email);
          this.loginSuccess = "Inicio de sesión exitoso";
          // Mostrar el mensaje por 3 segundos y luego borrarlo
          setTimeout(() => {
            this.loginSuccess = "";
          }, 1000);
        },
        error: (errorData) => {
          console.log(errorData);
          this.loginError = errorData;
        },
        complete: () => {
          console.info("Login completo");
          setTimeout(() => {
            this.router.navigateByUrl('');
          },2000);

          this.loginForm.reset();

        }
      })
    }
    else{
      this.loginForm.markAllAsTouched();
      alert("Error al ingresar los datos.");
    }
  }
}
