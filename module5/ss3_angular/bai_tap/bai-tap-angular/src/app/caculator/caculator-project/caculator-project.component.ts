import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator-project',
  templateUrl: './caculator-project.component.html',
  styleUrls: ['./caculator-project.component.css']
})
export class CaculatorProjectComponent implements OnInit {

  constructor() { }
  valueCaculator:string =""
  ngOnInit(): void {
  }
  changeValue(value){
    // if(typeof  value == "string" && flag == false) return
  this.valueCaculator += value.value;
  }
  resultCalulator(){
    this.valueCaculator = eval(this.valueCaculator).toString();
  }
  deleteValue(){
    this.valueCaculator= this.valueCaculator.slice(0,-1);
  }
  resetValue(){
    this.valueCaculator ="";
  }

}
