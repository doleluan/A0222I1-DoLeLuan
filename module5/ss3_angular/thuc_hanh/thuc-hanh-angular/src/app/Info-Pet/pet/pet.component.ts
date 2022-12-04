import { Component, OnInit } from '@angular/core';
import {Pet} from "./pet";
@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  pet:Pet ={
    name:'puppie',
    image:'https://jola.vn/Article/u0JmdVUZ9/www-easyvn-net-65-dogs-wallpapers-33.jpg'
  }
}

