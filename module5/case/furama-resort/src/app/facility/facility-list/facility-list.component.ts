import { Component, OnInit } from '@angular/core';
import {FacilityService} from "../../services/facility.service";
import {Facility} from "../../model/Facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilitys:Facility[]=[];
  facility:Facility;
  constructor(private facilityService : FacilityService) { }

  ngOnInit(): void {
    this.getAll();

  }
  getAll(){
   this.facilityService.getAll().subscribe(data=>{
      this.facilitys = data;
    })

  }
  deleteFacility() {
    this.facilityService.delete(this.facility.id).subscribe(date=>{
      this.ngOnInit();
    })
  }
  getInfo(facility) {
    this.facility = facility;
  }
  addNew() {
    this.facility=undefined;
  }
}
