import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ChangeFontsizeComponent } from './change-font-size/change-fontsize/change-fontsize.component';
import {FormsModule} from "@angular/forms";
import { PetComponent } from './Info-Pet/pet/pet.component';
import { ProductComponent } from './product-management/product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    ChangeFontsizeComponent,
    PetComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
