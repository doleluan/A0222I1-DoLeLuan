import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/Customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private  URL = "http://localhost:3000/customers";
  constructor(private httpClient :HttpClient) { }
  getAll(){
      return this.httpClient.get<Customer[]>(this.URL);
  }
  deleteCustomer(id){
    return this.httpClient.delete(this.URL+'/'+id)
  }
  saveFacility(customer){
    if (customer.id){
      return  this.httpClient.put(this.URL+"/"+customer.id,customer)
    }

    return this.httpClient.post(this.URL,customer)
  }
}
