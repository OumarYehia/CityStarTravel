import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  showNaveBar: boolean;

  constructor() { }

  ngOnInit() {
    this.showNaveBar = false;
  }

  toggleNavBar() {
    this.showNaveBar = !this.showNaveBar;
  }

}
