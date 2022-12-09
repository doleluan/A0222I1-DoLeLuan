import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CardComponent } from './name-card/card/card.component';
import { ProgressBarComponent } from './bar/progress-bar/progress-bar.component';
import { ChooseStarComponent } from './choose/choose-star/choose-star.component';
import { ChooseStarChildComponent } from './choose/choose-star-child/choose-star-child.component';
import { CountdownnComponent } from './countdown/countdownn/countdownn.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    ProgressBarComponent,
    ChooseStarComponent,
    ChooseStarChildComponent,
    CountdownnComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
