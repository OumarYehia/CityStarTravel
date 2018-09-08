import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LOCALE_ID, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './security/login/login.component';
import {AppMaterialModule} from './app-material/app-material.module';
import {AppRoutingModule} from './app-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import { HomeLayoutComponent } from './layouts/home-layout.component';
import { LoginLayoutComponent } from './layouts/login-layout.component';
import { SignupComponent } from './security/signup/signup.component';
import { BusesComponent } from './home/buses/buses.component';
import { WarehouseManagementComponent } from './home/warehouse-management/warehouse-management.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {HttpClientModule} from '@angular/common/http';
import { TripsComponent } from './home/trips/trips.component';
import {registerLocaleData} from '@angular/common';
import localeAr from '@angular/common/locales/ar';

registerLocaleData(localeAr);


import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';

// TODO: only include needed icons
library.add(fas, far);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    HomeLayoutComponent,
    LoginLayoutComponent,
    SignupComponent,
    BusesComponent,
    WarehouseManagementComponent,
    PageNotFoundComponent,
    TripsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FontAwesomeModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'ar' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
