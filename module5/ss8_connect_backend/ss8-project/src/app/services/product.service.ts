import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL = "http://localhost:3000/products"
  products:Product[];
  constructor(private httpClient: HttpClient) { }
  getAll():Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.URL);
  }
  saveProduct(product){
    console.log(product)
    return this.httpClient.post(this.URL,product);
  }
  deleteProduct(id){
    return this.httpClient.delete(this.URL+'/'+id);
  }
  findById(id):Observable<Product>{
    return this.httpClient.get<Product>(this.URL+'/'+id);
  }
}
