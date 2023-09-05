import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { GeneralDataRequest } from '../models/general-data-request';
import { Observable } from 'rxjs';
import { GeneralDataResponse } from '../models/general-data-response';

@Injectable({
  providedIn: 'root'
})
export class LoansApplicationService {
  apiUrl = environment.apiUrlLoanApp;

  constructor(private http: HttpClient) { }

  public saveGeneralData(data:GeneralDataRequest):Observable<GeneralDataResponse>{
    return this.http.post<GeneralDataResponse>(this.apiUrl + 'generalData', data);
  }
}
