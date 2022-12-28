import { Component, OnInit } from '@angular/core';
import {Contract} from "../../model/Contract";
import {ContractService} from "../../services/contract.service";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";
import {FacilityService} from "../../services/facility.service";
import {Customer} from "../../model/Customer";
import {Facility} from "../../model/Facility";

@Component({
  selector: 'app-contract-management',
  templateUrl: './contract-management.component.html',
  styleUrls: ['./contract-management.component.css']
})
export class ContractManagementComponent implements OnInit {
  contracts:Contract[];
  customers:Customer[];
  facilitys:Facility[];
  contract:Contract;
  rfForm:FormGroup
  constructor(private contractService : ContractService,private formBuilder : FormBuilder,private customerService:
  CustomerService,private facilityService : FacilityService) { }

  ngOnInit(): void {
    this.getContracts();
    this.getFacility();
    this.getCustomers();
    this.buildForm();
  }
  getContracts(){
    this.contractService.getAll().subscribe(data=>{
      this.contracts = data;
    })
  }
  getCustomers(){
    this.customerService.getAll().subscribe(data=>{
      this.customers = data;
    })
  }
  getFacility(){
    this.facilityService.getAll().subscribe(data=>{
      this.facilitys=data;    })
  }
  getInfo(contract) {
    this.contract = contract;
    this.buildForm();
  }
  buildForm(){
    this.rfForm=this.formBuilder.group({
      id:[this.contract===undefined ? "" : this.contract.id],
      code:[ this.contract===undefined ? "" : this.contract.code,],
      customer:[this.contract===undefined ? "" : this.contract.customer],
      facility:[ this.contract===undefined ? "" : this.contract.facility],
      startDay:[ this.contract===undefined ? "" : this.contract.startDay,],
      endDay:[ this.contract===undefined ? "" : this.contract.endDay],
      deposits:[ this.contract===undefined ? "" : this.contract.deposits,this.valitethan0],
    })
  }
  convertCustomer(id){
    let customer:Customer;
    customer = this.customers.filter(a=>{
      return a.id==id
    })[0]
    if (customer) return customer.name;
    return "Not Found"
  }
  convertFacility(id){
    let facility:Facility;
    facility = this.facilitys.filter(a=>{
      return a.id==id;
    })[0]
      if(facility) return facility.name
    return "Not Found";
  }
  addNew() {
    this.contract=undefined;
    this.buildForm();
  }
  submit() {
    this.contractService.saveContract(this.rfForm.value).subscribe(success=>{
      this.ngOnInit();
    })
  }
  valitethan0(c:AbstractControl){
    let number = c.value;
    if(number<0){
      return{
        "validThan0":true
      }
    }
    return null;
  }
}
