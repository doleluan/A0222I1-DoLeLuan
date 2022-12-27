import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Facility} from "../../model/Facility";
import {Router} from "@angular/router";
import {FacilityService} from "../../services/facility.service";
import {FacilityListComponent} from "../facility-list/facility-list.component";

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit,OnChanges {
  @Input()
  facility:Facility;

  rfForm :FormGroup;

  constructor(private formBuilder :FormBuilder,private router: Router,private facilityService:FacilityService
  , private  list :FacilityListComponent) { }

  ngOnInit(): void {
  }
  ngOnChanges(changes:SimpleChanges): void {
      this.facility = changes.facility.currentValue;
    this.buildThisForm();
  }
  buildThisForm(){
    this.rfForm = this.formBuilder.group({
      id:[this.facility===undefined ? "" : this.facility.id],
      name:[ this.facility===undefined ? "" : this.facility.name,Validators.pattern('\\D{0,}')],
      cost:[this.facility===undefined ? "" : this.facility.cost,[this.valitethan0,Validators.pattern('\\d{0,}')]],
      areaFacility:[ this.facility===undefined ? "" : this.facility.areaFacility,[this.valitethan0,Validators.pattern('\\d{0,}')]],
      poolArea:[ this.facility===undefined ? "" : this.facility.poolArea,[this.valitethan0,Validators.pattern('\\d{0,}')]],
      numberOfFloors:[ this.facility===undefined ? "" : this.facility.numberOfFloors,[this.valitethan0,Validators.pattern('\\d{0,}')]],
      standardRoom:[ this.facility===undefined ? "" : this.facility.standardRoom,Validators.required],
      maxPeople:[ this.facility===undefined ? "" : this.facility.maxPeople,[this.valitethan0,Validators.pattern('\\d{0,}')]],
      descriptionOtherConvenience:[ this.facility===undefined ? "" : this.facility.descriptionOtherConvenience,Validators.required]
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
  submit() {
    console.log(this.rfForm.value)
    this.facilityService.saveFacility(this.rfForm.value).subscribe(data=>{
      this.list.ngOnInit();
    })
  }
}
