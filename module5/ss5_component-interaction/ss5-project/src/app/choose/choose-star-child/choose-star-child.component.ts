import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IRatingUnit} from "../../model/IRatingUnit";

@Component({
  selector: 'app-choose-star-child',
  templateUrl: './choose-star-child.component.html',
  styleUrls: ['./choose-star-child.component.css']
})
export class ChooseStarChildComponent implements OnInit {
  @Input('rating')
  rating:IRatingUnit ={valueStar:1,active:"yellow"}
  @Output('createRating') onCreate  = new EventEmitter<number>()
  constructor() { }

  ngOnInit(): void {
  }
  vote(startValue:number){
    this.rating.valueStar=startValue;
    console.log(startValue)
    this.onCreate.emit(this.rating.valueStar);
  }
}
