import { Injectable } from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];
  getAll(){
    return this.products
  }
  saveProduct(product: Product) {
    let index =-1;
    for (let i=0;i<this.products.length;i++){
      if (this.products[i].id==product.id){
        index = i;break;
      }
    }
    index!=-1 ? this.products[index] = product : this.products.push()
    // if (index!=-1){this.products[index]=product;
    // }
    // else {
    //   this.products.push(product);
    // }
  }
  deleteProduct(id){
    this.products = this.products.filter(a=>{
      return a.id!==id;
    })
  }
  findById(id){
    return this.products.filter(a=>{return a.id==id})[0]
  }

  constructor() { }
}
