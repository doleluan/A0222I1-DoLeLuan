import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ArticleNewComponent } from './article/article-new/article-new.component';
import {FormsModule} from "@angular/forms";
import { LikeActionComponent } from './actionLike/like-action/like-action.component';
import { NavbarComponent } from './nav/navbar/navbar.component';
import { FooterComponent } from './foot/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleNewComponent,
    LikeActionComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
