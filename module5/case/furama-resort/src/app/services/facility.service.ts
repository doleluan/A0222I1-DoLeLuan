import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Facility} from "../model/Facility";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  URL = "http://localhost:3000/facility";
  constructor(private httpClient :HttpClient) { }
  getAll(){
    return this.httpClient.get<Facility[]>(this.URL);
  }
  saveFacility(facility){
    if (facility.id){
      return  this.httpClient.put(this.URL+"/"+facility.id,facility)
    }

    return this.httpClient.post(this.URL,facility)
  }
  delete(id){
   return this.httpClient.delete(this.URL+'/'+id);
  }
}
