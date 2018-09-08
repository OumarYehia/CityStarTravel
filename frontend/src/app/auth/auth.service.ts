import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Router} from '@angular/router';
import {NewUser, User} from './user';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
  }


  signup(user: NewUser) {
    return this.http.post(`${environment.API_URL}/signUp`, user);
  }

  login(user: User) {
    this.http.post(`${environment.API_URL}/signIn`, user).subscribe(
      data => {
        if (data === 1) {
          this.loggedIn.next(true);
          this.router.navigate(['/']);
        } else {
          alert('Wrong Credentials');
        }
      },
      error => {
        console.log(`${environment.API_URL}/signIn`);
        console.log('failed in login');
        console.log(error);
      }
    );
  }

  logout() {
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

}
