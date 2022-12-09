import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header-bootstrap/header/header.component';
import { Yeucau1Component } from './task1/yeucau1/yeucau1.component';
import { FooterComponent } from './footer-bootstrap/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    Yeucau1Component,
    FooterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
