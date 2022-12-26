import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Customer} from "../../model/Customer";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-save',
  templateUrl: './customer-save.component.html',
  styleUrls: ['./customer-save.component.css']
})
export class CustomerSaveComponent implements OnInit,OnChanges {
  @Input()
  customer :Customer;
  rfForm:FormGroup;
  constructor(private formBuilder :FormBuilder,private customerService : CustomerService) { }

  ngOnInit(): void {

  }
    buildThisForm(){
      this.rfForm = this.formBuilder.group({
        id:[this.customer===undefined ? "" : this.customer.id],
        name:[ this.customer===undefined ? "" : this.customer.name,],
        email:[this.customer===undefined ? "" : this.customer.email,],
        identify:[ this.customer===undefined ? "" : this.customer.identify,],
        phoneNumber:[ this.customer===undefined ? "" : this.customer.phoneNumber,],
        code:[ this.customer===undefined ? "" : this.customer.code,],
        dateOfBirth:[ this.customer===undefined ? "" : this.customer.dateOfBirth,Validators.required],
      })
    }

  submit() {
      this.customerService.saveFacility(this.rfForm.value).subscribe(data=>{
        this.ngOnInit();
      })

  }

  ngOnChanges(changes: SimpleChanges): void {
    this.buildThisForm();
  }
}
