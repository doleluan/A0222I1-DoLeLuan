import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFrom :FormGroup
  constructor() {
    this.loginFrom = new FormGroup(
      {
        name: new FormControl("",[Validators.pattern("^[\\w.+\\-]+@gmail\\.com$")]),
        password:new FormControl("",[Validators.minLength(6)])
      }
    )
  }
  loginForms(){
    console.log(this.loginFrom)
  }
  ngOnInit(): void {
  }

}
