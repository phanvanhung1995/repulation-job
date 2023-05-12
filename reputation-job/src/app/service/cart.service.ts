import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Cart} from "../model/cart";
import {CartDto} from "../dto/cart-dto";
import {Orders} from "../model/orders";
import {OrdersDto} from "../dto/orders-dto";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) {
  }

  addCart(cvId: number, candidateId: number): Observable<Cart> {
    return this.httpClient.get<Cart>('http://localhost:8080/api/candidate/cart/save/' + cvId + '/' + candidateId);
  }

  getAllCart(candidateId: number): Observable<CartDto[]> {
    return this.httpClient.get<CartDto[]>('http://localhost:8080/api/candidate/cart/list/' + candidateId);
  }

  deleteCartById(idDelete: number): Observable<Cart> {
    return this.httpClient.delete('http://localhost:8080/api/candidate/cart/delete/' + idDelete)
  }

  deleteCartAll(candidateId: number) {
    return this.httpClient.delete('http://localhost:8080/api/candidate/cart/deleteAll/' + candidateId)
  }

  getAllOrders(candidateId: number): Observable<OrdersDto[]> {
    return this.httpClient.get<OrdersDto[]>('http://localhost:8080/api/candidate/cart/history/' + candidateId)
  }
}
