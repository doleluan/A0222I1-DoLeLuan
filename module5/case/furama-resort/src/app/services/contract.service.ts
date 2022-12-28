import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contract} from "../model/Contract";

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  URL =  "http://localhost:3000/contract"
  constructor(private httpClient:HttpClient) { }
  getAll(){
    return this.httpClient.get<Contract[]>(this.URL);
  }
  saveContract(contract){
    if (contract.id){
      return  this.httpClient.put(this.URL+"/"+contract.id,contract)
    }

    return this.httpClient.post(this.URL,contract)
  }
}
