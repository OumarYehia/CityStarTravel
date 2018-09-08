import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Trip} from './trips';

@Injectable({
  providedIn: 'root'
})
export class TripsService {

  constructor(
    private http: HttpClient
  ) { }

  getTrips (): Observable<Trip[]> {
    return this.http.get<Trip[]>(`${environment.API_URL}/getTrips`);
  }
}
