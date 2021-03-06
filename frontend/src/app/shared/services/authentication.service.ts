import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post<any>(`${environment.apiUrl}/auth/signin`, { usernameOrEmail: username, password: password })
      .pipe(map(token => {
        // login successful if there's a jwt token in the response
        if (token && token.accessToken) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(token));
        }

        return token;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    console.log(localStorage.getItem('currentUser'));
    localStorage.removeItem('currentUser');
    console.log(localStorage.getItem('currentUser'));
  }
}
