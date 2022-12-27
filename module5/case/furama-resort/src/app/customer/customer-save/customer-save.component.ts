import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Customer} from "../../model/Customer";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";
import {CustomerListComponent} from "../customer-list/customer-list.component";

@Component({
  selector: 'app-customer-save',
  templateUrl: './customer-save.component.html',
  styleUrls: ['./customer-save.component.css']
})
export class CustomerSaveComponent implements OnInit,OnChanges {
  @Input()
  customer :Customer;
  rfForm:FormGroup;
  constructor(private formBuilder :FormBuilder,private customerService : CustomerService,private list:CustomerListComponent) { }

  ngOnInit(): void {
  }
    buildThisForm(){
      this.rfForm = this.formBuilder.group({
        id:[this.customer===undefined ? "" : this.customer.id],
        name:[ this.customer===undefined ? "" : this.customer.name,],
        email:[this.customer===undefined ? "" : this.customer.email,Validators.email],
        identify:[ this.customer===undefined ? "" : this.customer.identify,Validators.pattern('^(\\d{9}|\\d{11})$')],
        phoneNumber:[ this.customer===undefined ? "" : this.customer.phoneNumber,Validators.pattern('^(0|84)(90|91)\\d{7}$')],
        code:[ this.customer===undefined ? "" : this.customer.code,Validators.pattern('^KH-\\d{4}$')],
        dateOfBirth:[ this.customer===undefined ? "" : this.customer.dateOfBirth,Validators.required],
      })
    }

  submit() {
      this.customerService.saveFacility(this.rfForm.value).subscribe(data=>{
        this.list.ngOnInit();
      })

  }

  ngOnChanges(changes: SimpleChanges): void {
    this.buildThisForm();
  }
}
