import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../shared/services';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  providers: [AuthenticationService]
})
export class HeaderComponent implements OnInit {

  showNaveBar: boolean;

  constructor(
    private authService: AuthenticationService
  ) { }

  ngOnInit() {
    this.showNaveBar = false;
  }

  toggleNavBar() {
    this.showNaveBar = !this.showNaveBar;
  }

  logout() {
    console.log("log");
    this.authService.logout();
  }

}
