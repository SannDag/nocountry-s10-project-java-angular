import { Injectable } from '@angular/core';

const TOKEN_LOGIN = 'AuthToken';
const ROL_USER = 'RolUser';
const EMAIL_USER = 'EmailUser';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public setToken(token:string):void{
    localStorage.setItem(TOKEN_LOGIN, token);
  }

  public getToken(): string | null {
    return localStorage.getItem(TOKEN_LOGIN);
  }

  public setRol(rol:string):void{
    localStorage.setItem(ROL_USER, rol);
  }

  public getRol(): string | null {
    return localStorage.getItem(ROL_USER);
  }

  public setEmail(email:string):void{
    localStorage.setItem(EMAIL_USER, email);
  }

  public getEmail(): string | null{
    return localStorage.getItem(EMAIL_USER);
  }

  public logOut(): void{
    localStorage.removeItem(TOKEN_LOGIN);
  }

  public isLoggued(): boolean{
    return this.getToken() !== null;
  }

}
