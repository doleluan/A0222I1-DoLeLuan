import { Injectable } from '@angular/core';
import {IWord} from "../model/iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  private dictionaryWords:IWord [] =[{
    word:"dog",
    mean:"Chó",
  },
    {
      word:"cat",
      mean:"Mèo"
    },
    {
      word:"hello",
      mean: "Xin chào!"
    },
    {
      word:"world",
      mean:"Thế giới"
    }
  ]
  getAll(){
    return this.dictionaryWords;
  }
  findByKey(key:string){
    return this.dictionaryWords.filter(a=>{
      return a.word===key;
    })[0]
  }
  constructor() { }
}
