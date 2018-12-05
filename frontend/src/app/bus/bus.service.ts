import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Bus} from './bus.dto';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  constructor(private http: HttpClient) { }

  getBus(id: number) {
    const params = new HttpParams().set('id', id.toString());
    return this.http.get<Bus>(`${environment.apiUrl}/buses/getBus`, { headers: new HttpHeaders(), params: params });
  }
}
