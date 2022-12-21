import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductServiceService} from "../../services/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  rfStudent:FormGroup;
  product :Product;

  constructor(private  formBuilder: FormBuilder,private productServices : ProductServiceService,private  router : Router,
              private routerActive : ActivatedRoute) { }

  ngOnInit(): void {
    this.productServices.findById(this.routerActive.paramMap.subscribe((param:ParamMap)=>{
      this.findById(param.get("id"))
    }))
    this.rfStudent = this.formBuilder.group({
      id:[this.product===undefined ? "" : this.product.id],
      name:[this.product===undefined ? "" : this.product.name],
      price:[this.product===undefined ? "" : this.product.price],
      description:[this.product===undefined ? "" : this.product.description]
    })
  }
  submit() {
    const product = this.rfStudent.value;
    this.productServices.saveProduct(product);
    this.rfStudent.reset();
    this.router.navigateByUrl("product")
  }
  findById(id){
    this.product = this.productServices.findById(id)
  }
}
