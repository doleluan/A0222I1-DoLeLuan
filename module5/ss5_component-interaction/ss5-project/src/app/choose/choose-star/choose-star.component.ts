import {Component, Input, OnInit} from '@angular/core';
import {IRatingUnit} from "../../model/IRatingUnit";

@Component({
  selector: 'app-choose-star',
  templateUrl: './choose-star.component.html',
  styleUrls: ['./choose-star.component.css']
})
export class ChooseStarComponent implements OnInit {
  ratingStar:IRatingUnit={valueStar: 4,active:"red"}
  constructor() { }

  ngOnInit(): void {
  }

  vote(number: number) {
    this.ratingStar.valueStar = number;
  }

  getNewRating(valueSt: number) {
    this.ratingStar.valueStar = valueSt;
  }
}
