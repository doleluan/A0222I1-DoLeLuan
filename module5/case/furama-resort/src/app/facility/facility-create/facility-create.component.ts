import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Facility} from "../../model/Facility";
import {Router} from "@angular/router";
import {FacilityService} from "../../services/facility.service";

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  rfForm :FormGroup;
  facility:Facility;
  constructor(private formBuilder :FormBuilder,private router: Router,private facilityService:FacilityService) { }

  ngOnInit(): void {
    // this.buildThisForm();
  }
  // buildThisForm(){
  //   this.rfForm = this.formBuilder.group({
  //     id:[this.facility===undefined ? "" : this.facility.id],
  //     name:[ this.facility===undefined ? "" : this.facility.name],
  //     cost:[this.facility===undefined ? "" : this.facility.cost],
  //     areaFacility:[ this.facility===undefined ? "" : this.facility.areaFacility],
  //     poolArea:[ this.facility===undefined ? "" : this.facility.poolArea],
  //     numberOfFloors:[ this.facility===undefined ? "" : this.facility.numberOfFloors],
  //     standardRoom:[ this.facility===undefined ? "" : this.facility.standardRoom],
  //     maxPeople:[ this.facility===undefined ? "" : this.facility.maxPeople],
  //   })
  // }

  submit() {

  }
}
