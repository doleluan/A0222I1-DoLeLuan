import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderFuramaComponent } from './header/header-furama/header-furama.component';
import { FooterFuramaComponent } from './footer/footer-furama/footer-furama.component';
import { FacilityListComponent } from './facility/facility-list/facility-list.component';
import {HttpClientModule} from "@angular/common/http";
import { FacilityCreateComponent } from './facility/facility-create/facility-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerSaveComponent } from './customer/customer-save/customer-save.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderFuramaComponent,
    FooterFuramaComponent,
    FacilityListComponent,
    FacilityCreateComponent,
    CustomerListComponent,
    CustomerSaveComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
