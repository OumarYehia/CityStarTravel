import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Router} from '@angular/router';
import {NewUser, User} from './user';
import {HttpClient} from '@angular/common/http';

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

  API_URL = 'https://192.168.1.7:8443';

  signup(user: NewUser) {
    return this.http.post(`${this.API_URL}/signUp`, user);
  }

  login(user: User) {
    this.http.post(`${this.API_URL}/signIn`, user).subscribe(
      data => {
        console.log('successful login');
        this.loggedIn.next(true);
        this.router.navigate(['/']);
      },
      error => {
        console.log('failed in login');
        console.log(error);
      }
    );
    //
    // if (user.userName !== '' && user.password !== '') {
    //   this.loggedIn.next(true);
    //   this.router.navigate(['/']);
    // }
  }

  logout() {
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

}
