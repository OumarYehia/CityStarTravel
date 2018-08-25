import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {SparePart} from './warehouse-management';

@Injectable({
  providedIn: 'root'
})
export class WarehouseManagementService {

  constructor(
    private http: HttpClient
  ) { }

  getAllSpares(): Observable<SparePart[]> {
    return this.http.get<SparePart[]>(`${environment.API_URL}/getSpare`);
  }


  getSpareByID(busID): Observable<SparePart[]> {
    let params = new HttpParams().set('busID', busID);
    return this.http.get<SparePart[]>(`${environment.API_URL}/getSparesForBus`, {headers: new HttpHeaders(), params: params});
  }

}
