import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UiModule } from './ui/ui.module';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {AuthGuard} from './shared/guards';
import {AlertService, AuthenticationService, UserService} from './shared/services';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {ErrorInterceptor, fakeBackendProvider, JwtInterceptor} from './shared/helpers';
import {ReactiveFormsModule} from '@angular/forms';
import { BusDetailsComponent } from './bus/bus-details/bus-details.component';
import {NgxGaugeModule} from 'ngx-gauge';
import { VouchersComponent } from './vouchers/vouchers.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    BusDetailsComponent,
    VouchersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    UiModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxGaugeModule
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
