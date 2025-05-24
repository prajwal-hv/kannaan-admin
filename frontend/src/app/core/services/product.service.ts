import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = "http://localhost:8080/api/products"

  constructor(private httpClient: HttpClient) { }

  getProducts(page:number, size: number):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseUrl}?page=${page}&size=${size}`);
  }
  getProductById(id:string):Observable<Product>{
    return this.httpClient.get<Product>(`${this.baseUrl}/${id}`)
  }

  createProduct(product:Product):Observable<Product>{
    return this.httpClient.post<Product>(this.baseUrl,product)
  }

  updateProduct(id:string,product:Product):Observable<Product>{
    return this.httpClient.put<Product>(`${this.baseUrl}/${id}`,product);
  }

  deleteProduct(id:string | undefined):Observable<void>{
    if(id === undefined) return new Observable<void>();
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`)
  }
}
