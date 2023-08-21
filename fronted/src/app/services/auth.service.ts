import { Injectable } from '@angular/core';
import { LoginRequest } from '../models/login-request';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  urlAuth = 'http://20.121.214.190:5555/api/accounts/';

  constructor(private http:HttpClient){}

  login(request: LoginRequest):Observable<any> {
    return this.http.post<any>(this.urlAuth + 'login', request).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producio un error ', error.error);
    }
    else{
      console.error('Backend retornó el código de estado ', error.status, error.error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }

}
