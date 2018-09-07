import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Bus} from './bus';
import {SparePart} from '../warehouse-management/warehouse-management';


@Injectable({
  providedIn: 'root'
})
export class BusesService {

  constructor(
    private http: HttpClient
  ) {}

  getBuses (): Observable<Bus[]> {
    return this.http.get<Bus[]>(`${environment.API_URL}/getBus`);
  }

  createBus(bus: Bus) {
    return this.http.post(`${environment.API_URL}/createBus`, bus);
  }

  updateBus(bus: Bus) {
    return this.http.post(`${environment.API_URL}/updateBus`, bus);
  }

  deleteBus(busID: number) {
    let params = new HttpParams().set('busID', busID.toString());
    return this.http.delete(`${environment.API_URL}/deleteBus`, {headers: new HttpHeaders(), params: params});
  }
}
