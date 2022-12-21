import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../../services/dictionary-service.service";
import {IWord} from "../../model/iword";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-word-dictionary',
  templateUrl: './word-dictionary.component.html',
  styleUrls: ['./word-dictionary.component.css']
})
export class WordDictionaryComponent implements OnInit {
  dictionaryWords:IWord[];
  constructor(private  word : DictionaryServiceService,private active : ActivatedRoute) { }

  ngOnInit(): void {
    this.getAll();
  }
  translate(){

  }
  getAll(){
      return this.dictionaryWords = this.word.getAll();
  }
}
