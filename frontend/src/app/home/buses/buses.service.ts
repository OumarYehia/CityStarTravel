import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Bus} from './bus';


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
}
