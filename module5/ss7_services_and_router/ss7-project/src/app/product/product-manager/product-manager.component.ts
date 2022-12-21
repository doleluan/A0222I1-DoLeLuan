import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../../services/product-service.service";
import {Product} from "../../model/product";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-manager',
  templateUrl: './product-manager.component.html',
  styleUrls: ['./product-manager.component.css']
})
export class ProductManagerComponent implements OnInit {
  products: Product[] = [];
  constructor(private  productService : ProductServiceService,private active :ActivatedRoute,private  router:Router) { }

  ngOnInit(): void {
    this.getAll();
    this.active.paramMap.subscribe((paraMap:ParamMap)=>{
      this.deleteById(paraMap.get("id"));
    })
  }
  getAll(){
    this.products = this.productService.getAll();
  }

  deleteById(id){
    this.productService.deleteProduct(parseInt(id));
    this.router.navigateByUrl("product")
  }

}
