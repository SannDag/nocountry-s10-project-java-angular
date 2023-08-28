
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { LoginResponse } from '../models/login-response';
import { Observable, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

const TOKEN_LOGIN = 'AuthToken';
const ROL_USER = 'RolUser';
const EMAIL_USER = 'EmailUser';
const NAME_USER = 'NameUser';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private ubdateInterval = 1 * 60 * 1000;// 1minuto en milisegundos

  constructor(private authService:AuthService) { }

  private updateToken(): Observable<LoginResponse>{

    return this.authService.getCurrentSession();
  }

  startTokenUpdater(): Observable<LoginResponse> {
    return timer(0,this.ubdateInterval).pipe(

      switchMap(()=> this.updateToken())
    );
  }


  public setNameUser(name:string):void{
    localStorage.setItem(NAME_USER, name);
  }
  public getNameUser():string | null{
    return localStorage.getItem(NAME_USER);
  }

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
    localStorage.removeItem(ROL_USER);
    localStorage.removeItem(EMAIL_USER);
  }

  public isLoggued(): boolean{
    return this.getToken() !== null;
  }


}
