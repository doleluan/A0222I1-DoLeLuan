import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DictionaryServiceService} from "../../services/dictionary-service.service";
import {IWord} from "../../model/iword";

@Component({
  selector: 'app-word-detail',
  templateUrl: './word-detail.component.html',
  styleUrls: ['./word-detail.component.css']
})
export class WordDetailComponent implements OnInit {
  wordMean:IWord={
    word:"default",
    mean:"Mặc định"
  };
  constructor(private active :ActivatedRoute,private wordServices : DictionaryServiceService) { }

  ngOnInit(): void {
    this.active.paramMap.subscribe((paramap:ParamMap) =>{
      let  word = paramap.get("index");
      this.findByKey(word);
    })
  }
  findByKey(key:string){
    this.wordMean = this.wordServices.findByKey(key)

  }
}
