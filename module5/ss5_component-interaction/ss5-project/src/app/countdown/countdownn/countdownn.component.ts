import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdownn',
  templateUrl: './countdownn.component.html',
  styleUrls: ['./countdownn.component.css']
})
export class CountdownnComponent implements OnInit {
  time:number = 0;
  interval;
  startCountDown(){
    this.interval = setInterval(()=>{
      this.time++
    },1000)
  }
  stopCountDown(){
    clearInterval(this.interval)
  }
  resetCountDown(){
    this.time=0;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
