import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './security/login/login.component';
import {AuthGuard} from './auth/auth.guard';
import {LoginLayoutComponent} from './layouts/login-layout.component';
import {HomeLayoutComponent} from './layouts/home-layout.component';
import {SignupComponent} from './security/signup/signup.component';
import {BusesComponent} from './home/buses/buses.component';
import {WarehouseManagementComponent} from './home/warehouse-management/warehouse-management.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: '',
    component: HomeLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        component: HomeComponent,
        children: [
          {
            path: '',
            pathMatch: 'prefix',
            redirectTo: 'buses'
          },
          {
            path: 'buses',
            component: BusesComponent
          },
          {
            path: 'warehouseManagement/:id',
            component: WarehouseManagementComponent
          },
          {
            path: 'warehouseManagement',
            component: WarehouseManagementComponent
          }
        ]
      }
    ]
  },
  {
    path: '',
    component: LoginLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'signup',
        component: SignupComponent
      }
    ]
  },
  {path: '404', component: PageNotFoundComponent},
  {path: '**', pathMatch: 'full', redirectTo: '404'}
];

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
