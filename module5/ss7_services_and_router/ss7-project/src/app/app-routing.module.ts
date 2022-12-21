import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimeComponent} from "./caculater-time/time/time.component";
import {YoutubePlaylistComponent} from "./music/youtube-playlist/youtube-playlist.component";
import {ProductManagerComponent} from "./product/product-manager/product-manager.component";
import {ProductCreateComponent} from "./product/product-create/product-create.component";
import {WordDictionaryComponent} from "./word/word-dictionary/word-dictionary.component";
import {WordDetailComponent} from "./word/word-detail/word-detail.component";


const routes: Routes = [
  {
    path:"time",
    component:  TimeComponent
  },
  {
    path: "product/:id",
    component: ProductManagerComponent
  },
  {
    path:"product",
    component: ProductManagerComponent
  },
  {
    path: "create",
    component: ProductCreateComponent
  },
  {
    path: "product/edit/:id",
    component: ProductCreateComponent
  },
  {
    path:"translate",
    component: WordDictionaryComponent
  },
  {
    path: "detailWord/:index",
    component: WordDetailComponent
  }
  // {
  //   path: "youtube-playlist",
  //   component:YoutubePlaylistComponent,
  //   children: [{
  //     path: ':id',
  //     // component: YoutubePlayerComponent
  //   }]
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
