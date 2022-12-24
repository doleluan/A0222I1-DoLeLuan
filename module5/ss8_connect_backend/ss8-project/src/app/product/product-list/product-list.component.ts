import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[];
  private  subcription:Subscription;
  constructor(private  productService :ProductService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.subcription = this.productService.getAll().subscribe(data=>{
      this.products=data;
    },error => {
      console.log("Not Found")
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(data=>{
      this.ngOnInit();
    })
  }
}
