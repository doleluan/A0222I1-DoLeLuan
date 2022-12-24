import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  rfProduct:FormGroup;
  product:Product
  private  subcription:Subscription;
  constructor(private  formBuilder : FormBuilder,private router: Router,private productService :ProductService , private routerActive : ActivatedRoute) {

  }
  ngOnInit(): void {
    this.buildThisForm();
    if(this.router.url.includes("create")){
      return;
    }
    this.routerActive.paramMap.subscribe((param:ParamMap)=>{
      const idActive = param.get("id");
        this.productService.findById(idActive).subscribe(value => {
          this.product = value;
          this.buildThisForm();
        })
    })
  }
  submit() {
    this.product = this.rfProduct.value;
    this.productService.saveProduct(this.product).subscribe(data=>{
      this.router.navigateByUrl("/list")
    })
  }

  buildThisForm(){
    this.rfProduct = this.formBuilder.group({
      id:[this.product===undefined ? "" : this.product.id],
      name:[ this.product===undefined ? "" : this.product.name],
      price:[this.product===undefined ? "" : this.product.price],
      country:[ this.product===undefined ? "" : this.product.country],
      description:[ this.product===undefined ? "" : this.product.description]
    })
  }
}
