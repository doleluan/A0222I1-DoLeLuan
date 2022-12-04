import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-change-fontsize',
  templateUrl: './change-fontsize.component.html',
  styleUrls: ['./change-fontsize.component.css']
})
export class ChangeFontsizeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  fontSize = 14;
  changeFontSize(fontSize){
    this.fontSize = fontSize.value;
  }
}
