import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
const routes: Routes = [
  // {
  //   path: '',
  //   component: HomeLayoutComponent,
  //   // canActivate: [AuthGuard],
  //   children: [
  //     {
  //       path: '',
  //       component: HomeComponent,
  //       children: [
  //         {
  //           path: '',
  //           pathMatch: 'prefix',
  //           redirectTo: 'buses'
  //         },
  //         {
  //           path: 'buses',
  //           component: BusesComponent
  //         },
  //         {
  //           path: 'warehouseManagement',
  //           component: WarehouseManagementComponent
  //         }
  //       ]
  //     }
  //   ]
  // },
  // {
  //   path: '',
  //   component: LoginLayoutComponent,
  //   children: [
  //     {
  //       path: 'login',
  //       component: LoginComponent
  //     },
  //     {
  //       path: 'signup',
  //       component: SignupComponent
  //     }
  //   ]
  // },
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'bus', component: BusDetailsComponent },
  { path: 'vouchers', component: VouchersComponent },
  { path: 'register', component: RegisterComponent },
  { path: '404', component: PageNotFoundComponent },
  { path: '**', pathMatch: 'full', redirectTo: '404' }
];
import {AppComponent} from './app.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './shared/guards';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {BusDetailsComponent} from './bus/bus-details/bus-details.component';
import {VouchersComponent} from './vouchers/vouchers.component';

// import {HomeComponent} from './home/home.component';
// import {LoginComponent} from './security/login/login.component';
// import {AuthGuard} from './auth/auth.guard';
// import {LoginLayoutComponent} from './layouts/login-layout.component';
// import {HomeLayoutComponent} from './layouts/home-layout.component';
// import {SignupComponent} from './security/signup/signup.component';
// import {BusesComponent} from './home/buses/buses.component';
// import {WarehouseManagementComponent} from './home/warehouse-management/warehouse-management.component';
// import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

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
