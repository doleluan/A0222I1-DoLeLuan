import { Component, OnInit } from '@angular/core';
import {Student} from "../../model/student";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students:Student[]=[
    {
      id:1,
      name:"Hoàng dê",
      gender:1,
      point:9
    },
    {
      id:2,
      name:"Khanh",
      gender:1,
      point:8
    },{
      id:3,
      name:"Tuấn",
      gender:1,
      point:7
    }
    ,{
      id:4,
      name:"Khải",
      gender:1,
      point:6
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

  getFormTemplate(value: any) {
    console.log(value)
    this.students.unshift(value)
  }
}
