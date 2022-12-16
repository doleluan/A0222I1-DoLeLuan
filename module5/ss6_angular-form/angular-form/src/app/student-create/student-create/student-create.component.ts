import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../../model/student";
import {FormControl, FormGroup, NgForm} from "@angular/forms";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  @Output('createForm')
  submitForm = new EventEmitter();
  formReactive:FormGroup
  constructor() {
    this.formReactive = new FormGroup(
      {
        id: new FormControl(""),
        name: new FormControl(""),
        gender: new FormControl(""),
        point : new FormControl("")
      }
    )
  }

  ngOnInit(): void {
  }

  createFormTemplate(formTemplate: NgForm) {
    console.log(formTemplate)
    this.submitForm.emit(formTemplate.value)
  }
  createFromReactive(){
    console.log(this.formReactive)
    this.submitForm.emit(this.formReactive.value)
  }
}
