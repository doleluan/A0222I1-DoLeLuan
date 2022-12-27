import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../services/customer.service";
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers:Customer[]=[];
  customer:Customer;
  constructor(private customerService : CustomerService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.customerService.getAll().subscribe(data=>{
      this.customers=data;
    })
  }

  getInfo(customer) {
    this.customer = customer;
  }

  addNew() {
      this.customer=undefined;
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.customer.id).subscribe(data=>{
      this.ngOnInit();
    })
  }
}
