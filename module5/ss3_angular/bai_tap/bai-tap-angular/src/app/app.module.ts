import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CaculatorProjectComponent } from './caculator/caculator-project/caculator-project.component';
import { ColorPickerComponent } from './colorPicker/color-picker/color-picker.component';

@NgModule({
  declarations: [
    AppComponent,
    CaculatorProjectComponent,
    ColorPickerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
