import {Component, OnInit} from '@angular/core';
import {CartService} from "../../service/cart.service";
import {TokenStorageService} from "../../service/tokenStorage.service";
import {Orders} from "../../model/orders";
import {OrdersDto} from "../../dto/orders-dto";
import Swal from "sweetalert2";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  orderList: OrdersDto[];

  constructor(private cartService: CartService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders() {
    this.cartService.getAllOrders(this.tokenStorageService.getUser().id).subscribe(item => {
      this.orderList = item;
      console.log(item)
    })
  }
}
