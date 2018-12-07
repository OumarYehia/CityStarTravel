import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
const routes: Routes = [

  { path: '', canActivate: [AuthGuard], children: [
      { path: '', component: HomeComponent },
      { path: 'bus', component: BusDetailsComponent, children: [
          {path: '', component: BusEventsComponent},
          {path: 'events', component: BusEventsComponent}
        ]
      },
      { path: 'vouchers', component: VouchersComponent },
      { path: 'user', component: ProfileComponent},
    ] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '404', component: PageNotFoundComponent },
  { path: '**', pathMatch: 'full', redirectTo: '404' }
];


import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './shared/guards';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {BusDetailsComponent} from './bus/bus-details/bus-details.component';
import {VouchersComponent} from './vouchers/vouchers.component';
import {ProfileComponent} from './profile/profile.component';
import {BusEventsComponent} from './bus/bus-details/bus-events/bus-events.component';



@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
