import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimeComponent } from './caculater-time/time/time.component';
import { YoutubePlaylistComponent } from './music/youtube-playlist/youtube-playlist.component';
import { ProductManagerComponent } from './product/product-manager/product-manager.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { WordDictionaryComponent } from './word/word-dictionary/word-dictionary.component';
import { WordDetailComponent } from './word/word-detail/word-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    TimeComponent,
    YoutubePlaylistComponent,
    ProductManagerComponent,
    ProductCreateComponent,
    WordDictionaryComponent,
    WordDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
