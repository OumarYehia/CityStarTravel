import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AlertComponent } from './alert/alert.component';
import {AppRoutingModule} from '../app-routing.module';
import {NgProgressModule} from '@ngx-progressbar/core';
import {NgProgressHttpModule} from '@ngx-progressbar/http';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    NgProgressModule.forRoot({
      direction: 'rtl+',
      spinnerPosition: 'left',
      color: '#FFA81F'
    }),
    NgProgressHttpModule.forRoot()
  ],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent, AlertComponent],
  exports: [LayoutComponent]
})
export class UiModule { }
