import { Injectable } from '@angular/core';
import { LoginRequest } from '../models/login-request';
import { Registro } from '../models/registro';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, catchError, tap, throwError } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  urlAuth = 'https://s10-14-ft-api-gateway.azurewebsites.net/api/accounts/';
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http:HttpClient){}

  login(request: LoginRequest):Observable<any> {
    return this.http.post<any>(this.urlAuth + 'login', request).pipe(
      catchError(this.handleError)
    );
  }

  loginMock(request:LoginRequest):Observable<any>{
    return this.http.get<any>('././assets/loginRequest.json').pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error:HttpErrorResponse){
    if(error.status === 0){
      console.error('Se ha producio un error ', error.error);
    }
    else{
      console.error('Backend retornó el código de estado ', error.status, error.error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }


  registro(registro:Registro):Observable<any>{
    return this.http.post<any>(this.urlAuth + 'register', registro);

  }

}
