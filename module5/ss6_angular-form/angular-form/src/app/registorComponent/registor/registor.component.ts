import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-registor',
  templateUrl: './registor.component.html',
  styleUrls: ['./registor.component.css']
})
export class RegistorComponent implements OnInit {

  loginFrom :FormGroup
  listCountry:string[] = ["Vietnamese","China","Brazil","USA","Japan","Russia"]
   validatePassword(c:AbstractControl){
    const v = c.value
    return (v.password===v.comfirmPassword) ? null :{
      passwordnotmatch: true
    }
  }
  constructor() {
    this.loginFrom = new FormGroup(
      {
        email: new FormControl("",[Validators.pattern("^[\\w.+\\-]+@gmail\\.com$")]),
        pwGroup: new FormGroup({
          password:new FormControl("",[Validators.minLength(6)]),
          comfirmPassword:new FormControl("")
        },this.validatePassword),
        country: new FormControl(""),
        age: new FormControl("",[this.validateAge]),
        gender: new FormControl(),
        phone : new FormControl("",[Validators.pattern("^(\\84|0)\\d{9}$")])
      }
    )
  }
  validateAge(c:AbstractControl){
    // const now = new Date().toISOString().split('T')[0].toString()
    const date2 = new Date(new Date().toISOString().split('T')[0].toString())
    const date1 = new Date(c.value.toString())
    const validAge = Math.floor(((date2.getTime() - date1.getTime())/86400000)/365.25);
    if (validAge<18){
      return{
        'validAge':true
      }
      return null;
    }
  }
  loginForms(){

  }
  ngOnInit(): void {
  }

}
