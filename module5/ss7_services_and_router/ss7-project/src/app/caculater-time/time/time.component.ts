import { Component, OnInit } from '@angular/core';
import {ServiceTimeService} from "../../services/service-time.service";

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  output = '';

  constructor(private dateUtilService: ServiceTimeService) {
  }

  ngOnInit() {
  }

  onChange(value) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }



}
